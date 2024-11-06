# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 18:57:25 2024

@author: brand
"""
#printing header
print('Factorial Calculator')
print()
#setting fact as 1 and getting user input
fact = 1
n = int(input("Enter a number: "))
print()
#validation to check if the user's input is negative
while n < 0:
    print('You cannot enter a negative number. Please try again.')
    n = int(input("Enter a number: "))
#printing the statement before the factorial
print('The factorial of '+ str(n) +' is: ', end="")
#for loop for calculating factorial
for i in range(1,n+1):
    fact = fact * i
#printing factorial
print(fact)
