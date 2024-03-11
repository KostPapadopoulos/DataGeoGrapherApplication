import pandas as pd

def fix_iso():

    primary_csv_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\countries.csv'
    df_primary = pd.read_csv(primary_csv_path,encoding='ISO-8859-1')
    max_iso_code = df_primary['ISO_Code'].max()
    
    # Initialize a dictionary to map group names to ISO codes
    group_iso_map = {}
    
    # Function to generate new ISO codes
    def generate_new_iso_code(last_iso_code, increment=1):
        return last_iso_code + increment
    
    other_csv_paths = ['G:\\10th_semester\\Databases_2\\Data_Countries\\Forest_and_Carbon_UPDATED.csv', 'G:\\10th_semester\\Databases_2\\Data_Countries\\Land_Cover_Accounts_UPDATED.csv',
    'G:\\10th_semester\\Databases_2\\Data_Countries\\Climate-related_Disasters_Frequency_UPDATED.csv', 'G:\\10th_semester\\Databases_2\\Data_Countries\\Annual_Surface_Temperature_Change_UPDATED.csv'] 
    
    for path in other_csv_paths:
        df = pd.read_csv(path)
        
        # Assign new ISO codes to groups (entries without an ISO code)
        for index, row in df.iterrows():

            # For groups, check if they already have an ISO code assigned
            if pd.isna(row['ISO_Code']):

                group_name = row['Country']
                if group_name not in group_iso_map:

                    # Generate and assign a new ISO code for the group
                    max_iso_code = generate_new_iso_code(max_iso_code)
                    group_iso_map[group_name] = max_iso_code

                # Assign the ISO code from the map
                df.at[index, 'ISO_Code'] = group_iso_map[group_name]

        # Save the updated df back to CSV
        df.to_csv(path, index=False)
    
    print("ISO codes have been assigned to groups across all CSVs.")

def main_func():
    fix_iso()