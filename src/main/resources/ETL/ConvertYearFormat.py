import pandas as pd
 
def remove_prefix_and_extract_year(file):
    
    path = 'G:\\10th_semester\\Databases_2\\Data_Countries\\' + file
    df = pd.read_csv(path, encoding='ISO-8859-1')
 
    # Define a function to remove the "F" prefix and extract the year
    def extract_year(date_with_prefix):
        return int(date_with_prefix[1:])  # Remove the first character ("F") and convert to int
 
    # Apply the function to the second column
    df.iloc[:, 1] = df.iloc[:, 1].apply(extract_year)
 
    # Save the modified df back to a CSV file
    df.to_csv(path, index=False)
 
    print("Year fixed.")

def main_func():
    remove_prefix_and_extract_year('Annual_Surface_Temperature_Change_FINAL.csv')
    remove_prefix_and_extract_year('Climate-related_Disasters_Frequency_FINAL.csv')
    remove_prefix_and_extract_year('Forest_and_Carbon_FINAL.csv')
    remove_prefix_and_extract_year('Land_Cover_Accounts_FINAL.csv')