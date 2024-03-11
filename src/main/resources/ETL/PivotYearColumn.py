import pandas as pd

def fix_format(file_name, starting_column, new_file):

    csv_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + file_name
    df = pd.read_csv(csv_path, encoding='ISO-8859-1')
    
    
    id_vars = df.columns[:5].tolist() 
    id_vars.append(df.columns[-1])

    # Columns to unpivot: from the specified starting_column to the second-to-last
    value_vars = df.columns[starting_column:-1].tolist()
    
    # Unpivot the df from wide format to long format
    melted_df = pd.melt(df, id_vars=id_vars, var_name='Year', value_name='Value', value_vars=value_vars)
    
    
    # Pivot the melted df to get each unique metric as its own column
    # 'Indicator' values become column headers; we aggregate by the first identifier column and 'Year'
    pivoted_df = melted_df.pivot_table(index=[id_vars[-1], 'Year'], columns='Indicator', values='Value').reset_index()
    
    # Flatten the column headers
    pivoted_df.columns = [str(col) if col != '' else 'Year' for col in pivoted_df.columns]
    
    # Ensure all years are present for each indicator by reindexing
    year_range = df.columns[starting_column:-1]
    idx = pd.MultiIndex.from_product([pivoted_df[id_vars[-1]].unique(), year_range], names=[id_vars[-1], 'Year'])
    pivoted_df = pivoted_df.set_index([id_vars[-1], 'Year']).reindex(idx).reset_index()
    
    # Save the transformed df to a new CSV file
    new_csv_path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + new_file
    pivoted_df.to_csv(new_csv_path, index=False)
    
    print('Data transformation complete. Saved to ' + new_file)



def main_func():
    fix_format('Land_Cover_Accounts_UPDATED.csv', 11, 'Land_Cover_Accounts_YEARFIX.csv')
    fix_format('Climate-related_Disasters_Frequency_UPDATED.csv', 10, 'Climate-related_Disasters_Frequency_YEARFIX.csv')
    fix_format('Forest_and_Carbon_UPDATED.csv', 10, 'Forest_and_Carbon_YEARFIX.csv')
    fix_format('Annual_Surface_Temperature_Change_UPDATED.csv', 10, 'Annual_Surface_Temperature_Change_YEARFIX.csv')

