# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 18:14:28 2024

@author: brand
"""
print('Welcome to Stage of Your Life!\n')

age = int(input("Enter a person's age: "))

if age <= 1:
    print('\nhe or she is an infant')
if age > 1 and age < 13:
    print('\nhe or she is a child')
if age >= 13 and age < 20:
    print('\nhe or she is a teenager')
if age >= 20:
    print('\nhe or she is an adult')