# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 18:39:34 2024

@author: brand
"""
#table header
print('Celsius to Fahrenheit Table\n')
print(" | Celsius | Fahrenheit |")
print('-------------------------------')
#setting variable cel to 0
cel = 0
#for loop for calculation and printing the table
for cel in range (0,20 + 1):
    fah = int(((9/5)*cel)+32)
    print(' | ' + str(cel).ljust(6), ' | ' + str(fah).ljust(10) + ' | ')