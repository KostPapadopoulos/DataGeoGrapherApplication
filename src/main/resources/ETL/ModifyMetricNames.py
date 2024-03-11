import pandas as pd
import re
 
def extract_last_word_after_colon(column_name):

    match = re.search(r':\s*([^:]+)$', column_name)
    if match:
        last_word=match.group(1)
        last_word = last_word.replace(" ","_")
        return last_word
    else:
        return column_name
 
def fix_climate(filename):
    
    df = pd.read_csv(filename, encoding='ISO-8859-1')

    # Extract the last word after colon in each column name
    new_column_names = [extract_last_word_after_colon(col) for col in df.columns]

    # Rename the columns with the extracted names
    df.columns = new_column_names

    # Write the modified df to a new CSV file
    df.to_csv('G:\\10th_semester\\Databases_2\\Data_Countries\\Climate-related_Disasters_Frequency_FINAL.csv', index=False)
    print("completed climate")

def fix_temperature(filename):
   
    df = pd.read_csv(filename, encoding='ISO-8859-1')

    new_column_names = [col.split()[:2] for col in df.columns]

    new_column_names = ['_'.join(words) for words in new_column_names]

    # Rename the columns with the extracted names
    df.columns = new_column_names

    # Write the modified df to a new CSV file
    df.to_csv('G:\\10th_semester\\Databases_2\\Data_Countries\\Annual_Surface_Temperature_Change_FINAL.csv', index=False)
    print("completed temperature")

def fix_forest(filename):
    
    df = pd.read_csv(filename, encoding='ISO-8859-1')
    df.columns = df.columns.str.replace(" ","_")

    df.to_csv('G:\\10th_semester\\Databases_2\\Data_Countries\\Forest_and_Carbon_FINAL.csv', index=False)
    print("completed forest")

def fix_land(filename):
    
    df = pd.read_csv(filename, encoding='ISO-8859-1')
    for index, (column_name, column_values) in enumerate(df.iteritems()):

        if index == 10:  # Check if it's the K column

            # Extract the part before the comma and replace spaces with underscores
            new_column_name = column_name.split(',')[0].replace(' ', '_').replace('/','_')

            # Rename the column with the new name
            df.rename(columns={column_name: new_column_name}, inplace=True)

        elif index == 2:  # Check if it's the C column
            
            # Extract the part before the parenthesis and replace spaces with underscores
            new_column_name = column_name.split(' (')[0].replace(' ', '_')

            # Rename the column with the new name
            df.rename(columns={column_name: new_column_name}, inplace=True)

        else:  # For the remaining columns

            # Replace spaces and hyphen with underscores
            new_column_name = column_name.replace(' ', '_').replace('-','_')

            # Rename the column with the new name
            df.rename(columns={column_name: new_column_name}, inplace=True)
            
    # Write the modified df to a new CSV file
    df.to_csv('G:\\10th_semester\\Databases_2\\Data_Countries\\Land_Cover_Accounts_FINAL.csv', index=False)
    print("completed land")

def main_func():
    fix_climate('G:\\10th_semester\\Databases_2\\Data_Countries\\Climate-related_Disasters_Frequency_YEARFIX.csv')
    fix_temperature('G:\\10th_semester\\Databases_2\\Data_Countries\\Annual_Surface_Temperature_Change_YEARFIX.csv')
    fix_forest('G:\\10th_semester\\Databases_2\\Data_Countries\\Forest_and_Carbon_YEARFIX.csv')
    fix_land('G:\\10th_semester\\Databases_2\\Data_Countries\\Land_Cover_Accounts_YEARFIX.csv')