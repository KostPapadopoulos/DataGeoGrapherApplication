import pandas as pd

def add_ISO_Code():
    master_csv_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\countries.csv'

    master_df = pd.read_csv(master_csv_path, encoding='ISO-8859-1')

    # Mapping from ISO3 to ISO_Code
    iso3_to_isocode_map = pd.Series(master_df.iloc[:, 2].values, index=master_df.iloc[:, 1]).to_dict()

    # List of CSV paths to be updated with ISO_Code
    other_csv_paths = [
        'G:\\10th_semester\\Databases_2\\Data_Countries\\Annual_Surface_Temperature_Change.csv',
        'G:\\10th_semester\\Databases_2\\Data_Countries\\Climate-related_Disasters_Frequency.csv',
        'G:\\10th_semester\\Databases_2\\Data_Countries\\Forest_and_Carbon.csv',
        'G:\\10th_semester\\Databases_2\\Data_Countries\\Land_Cover_Accounts.csv'
    ]


    other_df = pd.read_csv(other_csv_paths[0], encoding='ISO-8859-1')

    # Check if 'ISO3' column exists in other_df
    if 'ISO3' in other_df.columns:

        # Use the mapping to add a new column 'ISO_Code' to other_df based on 'ISO3'
        other_df['ISO_Code'] = other_df['ISO3'].map(iso3_to_isocode_map)

        # Construct the updated CSV file path
        updated_csv_path1 = other_csv_paths[0].replace('Annual_Surface_Temperature_Change.csv', 'Annual_Surface_Temperature_Change_UPDATED.csv')

        # Save the updated df to a new CSV file
        other_df.to_csv(updated_csv_path1, index=False)
        
        print(f'Updated file saved to: {updated_csv_path1}')
    else:
        print(f'The column ISO3 does not exist in the file: {other_csv_paths[0]}')


    other_df = pd.read_csv(other_csv_paths[1], encoding='ISO-8859-1')

    # Check if 'ISO3' column exists in other_df
    if 'ISO3' in other_df.columns:

        # Use the mapping to add a new column 'ISO_Code' to other_df based on 'ISO3'
        other_df['ISO_Code'] = other_df['ISO3'].map(iso3_to_isocode_map)

        # Construct the updated CSV file path
        updated_csv_path2 = other_csv_paths[1].replace('Climate-related_Disasters_Frequency.csv', 'Climate-related_Disasters_Frequency_UPDATED.csv')

        # Save the updated df to a new CSV file
        other_df.to_csv(updated_csv_path2, index=False)
        
        print(f'Updated file saved to: {updated_csv_path2}')

    else:
        print(f'The column ISO3 does not exist in the file: {other_csv_paths[1]}')


    other_df = pd.read_csv(other_csv_paths[2], encoding='ISO-8859-1')

    # Check if 'ISO3' column exists in other_df
    if 'ISO3' in other_df.columns:

        # Use the mapping to add a new column 'ISO_Code' to other_df based on 'ISO3'
        other_df['ISO_Code'] = other_df['ISO3'].map(iso3_to_isocode_map)

        # Construct the updated CSV file path
        updated_csv_path3 = other_csv_paths[2].replace('Forest_and_Carbon.csv', 'Forest_and_Carbon_UPDATED.csv')

        # Save the updated df to a new CSV file
        other_df.to_csv(updated_csv_path3, index=False)
        
        print(f'Updated file saved to: {updated_csv_path3}')
    else:
        print(f'The column ISO3 does not exist in the file: {other_csv_paths[2]}')


    other_df = pd.read_csv(other_csv_paths[3], encoding='ISO-8859-1')

    # Check if 'ISO3' column exists in other_df
    if 'ISO3' in other_df.columns:
        
        # Use the mapping to add a new column 'ISO_Code' to other_df based on 'ISO3'
        other_df['ISO_Code'] = other_df['ISO3'].map(iso3_to_isocode_map)

        # Construct the updated CSV file path
        updated_csv_path4 = other_csv_paths[3].replace('Land_Cover_Accounts.csv', 'Land_Cover_Accounts_UPDATED.csv')

        # Save the updated df to a new CSV file
        other_df.to_csv(updated_csv_path4, index=False)
        
        print(f'Updated file saved to: {updated_csv_path4}')
    else:
        print(f'The column ISO3 does not exist in the file: {other_csv_paths[3]}')

def main_func():
    add_ISO_Code()