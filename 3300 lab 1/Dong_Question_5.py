# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 18:57:25 2024

@author: brand
"""
print('Factorial Calculator')
print()

fact = 1
n = int(input("Enter a number: "))
print()

while n < 0:
    print('You cannot enter a negative number. Please try again.')
    n = int(input("Enter a number: "))

print('The factorial of '+ str(n) +' is: ', end="")

for i in range(1,n+1):
    fact = fact * i

print(fact)
