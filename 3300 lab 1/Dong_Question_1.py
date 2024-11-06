# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 17:40:11 2024

@author: brand
"""
print("Welcome to What Day is it!\n")
x = int(input('\nEnter a number 1-7 to select a day: '))

days = ['random','Monday','Tuesday','Wednesday','Thursday','Friday', 'Saturday', 'Sunday']
a = range(1,7+1)

if (x not in a):
    print("\nYou can only enter a number 1-7. Please try again.\n")
else:
    print('\nSelected day: ', days[x])
    

