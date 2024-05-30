import pandas as pd

def update_countries_from_csv(new_file):
    
    countries_csv = 'G:\\10th_semester\\Databases_2\\Data_Countries\\countries.csv'
    other_csv_paths = ['G:\\10th_semester\\Databases_2\\Data_Countries\\Forest_and_Carbon_UPDATED.csv', 'G:\\10th_semester\\Databases_2\\Data_Countries\\Land_Cover_Accounts_UPDATED.csv',
    'G:\\10th_semester\\Databases_2\\Data_Countries\\Climate-related_Disasters_Frequency_UPDATED.csv', 'G:\\10th_semester\\Databases_2\\Data_Countries\\Annual_Surface_Temperature_Change_UPDATED.csv']  # Update these paths
    countries_df = pd.read_csv(countries_csv,encoding='ISO-8859-1')

    for path in other_csv_paths:
        df = pd.read_csv(path,encoding='ISO-8859-1')
        iso_code_second_csv = df.columns[-1]
        new_iso_codes = df[~df[iso_code_second_csv].isin(countries_df['ISO_Code'])]

        # Iterate over these new ISO codes to add them to the countries CSV
        for index, row in new_iso_codes.iterrows():
            new_row = {
                'Display_Name': row['Country'],  
                'ISO_Code': row[iso_code_second_csv]
            }
            countries_df = countries_df.append(new_row, ignore_index=True)

    # Removing duplicates
    countries_df.drop_duplicates(subset=['ISO_Code'], keep='first', inplace=True)

    # Save the updated df back to a CSV
    updated_csv_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + new_file
    countries_df.to_csv(updated_csv_path, index=False)

    print(f"CSV updated successfully. Updated file saved as: {updated_csv_path}")

def main_func():
    update_countries_from_csv('countries_MODIFIED.csv')