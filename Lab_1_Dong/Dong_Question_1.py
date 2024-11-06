# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 17:40:11 2024

@author: brand
"""
#printing header
print("Welcome to What Day is it!\n")
#getting the user input
x = int(input('\nEnter a number 1-7 to select a day: '))
#setting an array with the corresponding days
days = ['random','Monday','Tuesday','Wednesday','Thursday','Friday', 'Saturday', 'Sunday']
#setting a range to check if the input is between 1 and 7
a = range(1,7+1)
#if else statement to check if user input is in the range
if (x not in a):
    print("\nYou can only enter a number 1-7. Please try again.\n")
else:
    print('\nSelected day: ', days[x])
    

