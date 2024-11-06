# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 18:39:34 2024

@author: brand
"""
print('Fahrenheit to Celcius Table\n')
print(f" |{'Celcius'.ljust(12)}  |{'Fahrenheit'.ljust(11)} |")
cel = 0
for cel in range (0,20 + 1):
    fah = int(((9/5)*cel)+32)
    print(' | ' + str(cel).ljust(11), ' | ' + str(fah).ljust(7) + '    | ')