import AddISOCode
import AddGroupsToCountries
import AddNonExistingISOCode
import ConvertYearFormat
import CreateCustomID
import PivotYearColumn
import ModifyMetricNames
import MergeTables

def final_table_transformation():
    AddISOCode.main_func()
    AddNonExistingISOCode.main_func()
    PivotYearColumn.main_func()
    ModifyMetricNames.main_func()
    ConvertYearFormat.main_func()
    AddGroupsToCountries.main_func()
    MergeTables.main_func()
    CreateCustomID.main_func()

    print('Table Transformation Completed!')

if __name__ == '__main__':
    final_table_transformation()


