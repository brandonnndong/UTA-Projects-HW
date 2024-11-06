# -*- coding: utf-8 -*-
"""
Created on Tues Jun 18 5:13:08 2024

@author: dong
"""

import os

#assigning variables for menu selection
ADD_CHOICE = 1
SHOW_CHOICE = 2
SEARCH_CHOICE = 3
MODIFY_CHOICE = 4
DELETE_CHOICE = 5
QUIT_CHOICE = 6

#main function
def main():
    #while loop where if QUIT_CHOICE is not selected, then it'll always display menu with user input
    choice = 0
    while choice != QUIT_CHOICE:
        menu()
        choice = int(input('Please enter your choice: '))

        #if else statement for if user input equals a certain choice
        if choice == ADD_CHOICE:
            add()             
        elif choice == SHOW_CHOICE:
            show()             
        elif choice == SEARCH_CHOICE:
            search()
        elif choice == MODIFY_CHOICE:
            modify()
        elif choice == DELETE_CHOICE:
            delete()
        elif choice == QUIT_CHOICE:
            print('Exiting the program...')
        else:
            print('Error: invalid selection.')

#display menu 
def menu():
    print('  CHOICE MENU  ')
    print('1) Add a contact')
    print('2) Show the list of contacts')
    print('3) Search for a contact in the list')
    print('4) Modify a contact')
    print('5) Delete a contact from the list')    
    print('6) Quit')
    
#add function
def add():
    another = 'y'

    #opens the contact.txt file to append
    contact_file = open('contact.txt', 'a')

    #while loop for if the user wants to input another contact
    while another == 'y' or another == 'Y':
        #users input to append the contact.txt file
        print('Enter the following contact info:')
        name = input('Name: ')
        email = input('Email: ')
        phone = input('Phone Number: ')

        #writes the user input into the .txt file
        contact_file.write(name + '\n')
        contact_file.write(email + '\n')
        contact_file.write(phone + '\n')

        #ask if user wants to input another contact
        print('Do you want to add another record?')
        another = input('Y = yes, anything else = no: ')

    #closes file
    contact_file.close()
    print('Data appended to contact.txt.')
    
#show function
def show():
    
    #will try to open and print out the entire contact.txt file
    try:
        #opens file to read
        contact_file = open('contact.txt', 'r')

        #reads the name in file
        name = contact_file.readline()
        print('\nList of contact(s)\n')
        #while there are name items, itll read all names, emails, and phone numbers to print
        while name != '':
            email = contact_file.readline()
            phone = contact_file.readline()

            name = name.rstrip('\n')
            email = email.rstrip('\n')

            print('Name:', name)
            print('Email:', email)
            print('Phone:', phone)
            print('-------------------')

            name = contact_file.readline()

        contact_file.close()
    #if not the it'll print error message
    except IOError as err:
        print(err)
    
#search function
def search():
    #sets found to false
    found = False

    #user input to search for the name
    search = input('Enter a name to search for: ')

    #opens file to read
    contact_file = open('contact.txt', 'r')

    #reads the names in the file
    name = contact_file.readline()

    #while there are name items
    while name != '':
        email = contact_file.readline()
        phone = contact_file.readline()

        name = name.rstrip('\n')
        email = email.rstrip('\n')

        #if the user input matches any of the names then it'll print the corresponding contact info and sets found to true
        if name == search:
            print('Name:', name)
            print('Email:', email)
            print('Phone:', phone)
            print()
            found = True

        name = contact_file.readline()

    #closes file
    contact_file.close()

    #if name isnt found, it'll print this msg
    if not found:
        print('That contact was not found in the file.')
        
#delete function
def delete():

    #sets found to false
    found = False
    #users input to search for contact
    search = input('Which contact do you want to delete? ')
    #opens file to read
    contact_file = open('contact.txt', 'r')
    #creates and opens a temp.txt file to write
    temp_file = open('temp.txt', 'w')
    #reads names in file
    name = contact_file.readline()

    #while there are name items
    while name != '':
        email = contact_file.readline()
        phone = contact_file.readline()

        name = name.rstrip('\n')
        email = email.rstrip('\n')

        #writes all contact info not matching the user inputed name into the temp.txt file
        if name != search:
            temp_file.write(name + '\n')
            temp_file.write(email + '\n')
            temp_file.write(str(phone) + '\n')
        else:
            found = True
            
        name = contact_file.readline()

    #closes both files
    contact_file.close()
    temp_file.close()

    #removes the old contact.txt file
    os.remove('contact.txt')
    #renames temp file to contact.txt file
    os.rename('temp.txt', 'contact.txt')

    #prints msg if name was found
    if found:
        print('The file has been updated.')
    #prints msg if name wasn't found
    else:
        print('That item was not found in the file.')
        
#modify function
def modify():
    
    #sets found to false
    found = False
    #user input for updates contact info
    search = input('Enter a name to search for: ')
    new_email = input('Enter the new email for update: ')
    new_phone = int(input('Enter the new phone for update: '))
    
    #opens contact file to read
    contact_file = open('contact.txt', 'r')
    #opens new temp file to write
    temp_file = open('temp.txt', 'w')
    #reads names in contact file
    name = contact_file.readline()

    #while there are name items
    while name != '':
        email = contact_file.readline()
        phone = contact_file.readline()

        name = name.rstrip('\n')
        email = email.rstrip('\n')

        #if user input (search) matches any of the names in the file
        if name == search:
            #writes new inputs into the temp file
            temp_file.write(name + '\n')
            temp_file.write(new_email + '\n')
            temp_file.write(str(new_phone) + '\n')

            found = True
        else:
            #if it doesn't match any names, it'll write the old info back into the file
            temp_file.write(name + '\n')
            temp_file.write(email + '\n')
            temp_file.write(str(phone) + '\n')

        name = contact_file.readline()

    #closes files
    contact_file.close()
    temp_file.close()
    #removes the old contact.txt file
    os.remove('contact.txt')
    #renames temp file to contact.txt file
    os.rename('temp.txt', 'contact.txt')

    #prints msg if name was found
    if found:
        print('The file has been updated.')
    #prints msg if name wasn't found
    else:
        print('That item was not found in the file.')

main()