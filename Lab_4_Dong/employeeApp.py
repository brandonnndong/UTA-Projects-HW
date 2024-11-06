import pickle
import employee

#constants for menu
LOOK_UP = 1
ADD = 2
CHANGE = 3
DELETE = 4
QUIT = 5

#constant for filename
FILENAME = 'employees.dat'

def main():
    myEmployees = load_employee()
    choice = 0
    
    while choice != QUIT:
        choice = menu_choice()
        
        if choice == LOOK_UP:
            lookup(myEmployees)
        elif choice == ADD:
            add(myEmployees)
        elif choice == CHANGE:
            change(myEmployees)
        elif choice == DELETE:
            delete(myEmployees)
        elif choice == QUIT:
            break
            
    save(myEmployees)
    
def load_employee():
    try:
        input_file = open(FILENAME, 'rb')
        employee_dct = pickle.load(input_file)
        input_file.close()
    except IOError:
        employee_dct = {}
    return employee_dct

def menu_choice():
    print()
    print('MENU')
    print('Choose options 1-5')
    print('-' * 20)
    print('1 - look up employee')
    print('2 - add new employee')
    print('3 - change employee info')
    print('4 - delete employee')
    print('5 - quit program')
    print()
    
    choice = int(input('Enter choice: '))
    
    while choice < LOOK_UP or choice > QUIT:
        choice = int(input('Enter a valid choice: '))
    return choice
def lookup(myEmployees):
    name = input('Enter employee name: ')
    print(myEmployees.get(name, ' is not found.'))
    
def add(myEmployees):
    IDnumber = input('Enter employee ID: ')
    name = input('Enter employee name: ')
    department = input('Enter department: ')
    job_title = input('Enter job title: ')
    
    entry = employee.Employee(name,IDnumber,department,job_title)
    
    if name not in myEmployees:
        myEmployees[name] = entry
        print('Employee added.')
    else:
        print('Employee already exist.')
def change(myEmployees):
    IDnumber = input('Enter employee ID number:')
    name = input('Enter employee name: ')
    
    if name in myEmployees:
        department = input('Enter a new department: ')
        job_title = input('Enter a new job title: ')
        
        entry = employee.Employee(name, IDnumber, department, job_title)
        
        myEmployees[name] = entry
        print('Employee info was updated.')
    else:
        print('Name is not found.')
def delete(myEmployees):
    name = input('Enter employee name: ')
    
    if name in myEmployees:
        del myEmployees[name]
        print('Employee info was deleted.')
    else:
        print('Name is not found.')
def save(myEmployees):
    output = open(FILENAME, 'wb')
    pickle.dump(myEmployees, output)
    output.close()

main()