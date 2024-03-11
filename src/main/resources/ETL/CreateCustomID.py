import pandas as pd

def custom_ID(): 
    
    df1 = pd.read_csv('G:\\10th_semester\\Databases_2\\Data_Countries\\Climate_Disasters_Temperature_Change.csv')  # Adjust the path to your first CSV file
    df2 = pd.read_csv('G:\\10th_semester\\Databases_2\\Data_Countries\\Forest_Carbon_Land_Cover.csv') # Adjust the path to your second CSV file
    
    # Concatenate the two df to ensure all combinations are covered, keeping only 'ISO_Code' and 'Year'
    all_combinations = pd.concat([df1[['ISO_Code', 'Year']], df2[['ISO_Code', 'Year']]], ignore_index=True)
    
    # Drop duplicates to keep unique combinations and reset the index to get a unique identifier
    unique_combinations = all_combinations.drop_duplicates().reset_index(drop=True)
    
    # Create a new column 'ID' which will serve as our unique identifier, starting from 1
    unique_combinations['ID'] = unique_combinations.index + 1
    
    # Merge the unique index back into the original df based on 'ISO_Code' and 'Year'
    df1_with_index = pd.merge(df1, unique_combinations, on=['ISO_Code', 'Year'], how='left')
    df2_with_index = pd.merge(df2, unique_combinations, on=['ISO_Code', 'Year'], how='left')

    # Reorder columns to make 'ID' the first column
    cols1 = df1_with_index.columns.tolist()
    cols1 = [cols1[-1]] + cols1[:-1]
    df1_with_index = df1_with_index[cols1]
    cols2 = df2_with_index.columns.tolist()
    cols2 = [cols2[-1]] + cols2[:-1]
    df2_with_index = df2_with_index[cols2]
    
    # Save the updated df to new CSV files, without the df index
    df1_with_index.to_csv('G:\\10th_semester\\Databases_2\\Data_Countries\\Climate_Disasters_Temperature_Change.csv', index=False)
    df2_with_index.to_csv('G:\\10th_semester\\Databases_2\\Data_Countries\\Forest_Carbon_Land_Cover.csv', index=False)

    print('Custom ID Added Successfully')

def main_func():
    custom_ID()