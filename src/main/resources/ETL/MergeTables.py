import pandas as pd
 
def merge_temp_climate(csv1_file, csv2_file, output_file):
    
    first_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + csv1_file
    second_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + csv2_file
    output_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + output_file
    df1 = pd.read_csv(first_path,encoding='ISO-8859-1')
    df2 = pd.read_csv(second_path,encoding='ISO-8859-1')
 

    # 'Iso_Code' and 'Year' are the first two columns. Setting them as indices for merging
    df1.set_index(['ISO_Code', 'Year'], inplace=True)
    df2.set_index(['ISO_Code', 'Year'], inplace=True)
    
    # Perform an outer join to include all data, leaving missing data as empty cells
    merged_df = df1.join(df2, how='outer', lsuffix='_df1', rsuffix='_df2')
    
    # Reset index in order to make 'Iso_Code' and 'Year' regular columns
    merged_df.reset_index(inplace=True)
    
    # Save the merged df to a CSV file
    merged_df.to_csv(output_path, index=False)
 
    print("Merged temperature with climate CSV.")
 

def merge_forest_land(csv1_file, csv2_file, output_file):
    
    first_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + csv1_file
    second_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + csv2_file
    output_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + output_file
    df1 = pd.read_csv(first_path,encoding='ISO-8859-1')
    df2 = pd.read_csv(second_path,encoding='ISO-8859-1')
    
    # Perform an outer join to include all data, leaving missing data as empty cells
    merged_df = pd.merge(df1,df2, on = ['ISO_Code', 'Year'])
    
    # Save the merged df to a CSV file
    merged_df.to_csv(output_path, index=False)
 
    print("Merged forest and land CSV.")

def main_func():
    merge_temp_climate('Annual_Surface_Temperature_Change_FINAL.csv', 'Climate-related_Disasters_Frequency_FINAL.csv', 'Climate_Disasters_Temperature_Change.csv')
    merge_forest_land('Forest_and_Carbon_FINAL.csv','Land_Cover_Accounts_FINAL.csv','Forest_Carbon_Land_Cover.csv')