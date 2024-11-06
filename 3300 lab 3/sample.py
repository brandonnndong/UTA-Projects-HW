# -*- coding: utf-8 -*-
"""
Created on Tues Jul 2 5:13:08 2024

@author: dong
"""
import sqlite3 

def menu():
  print('\nCommand Menu')
  print('view - view players')
  print('add - add players')
  print('del - delete a player')
  print('update - update a player')
  print('exit - exit a program')

def view():
  conn = sqlite3.connect('players_Data.db')
  cursor = conn.execute("SELECT name, wins, losses, ties FROM Player")

  print("{0:16}{1:10}{2:10}{3:10}{4:10}".format("name","wins","losses","ties","games"))
  print("-"*60)
  for row in cursor:
    print("{0:10}{1:10}{2:10}{3:10}{4:10}".format(row[0].capitalize(), row[1], row[2], row[3],
                                                row[1]+row[2]+row[3]))
    print()
  conn.close()

def add():
  conn = sqlite3.connect('players_Data.db')
  name = input("Name: ")
  win = int(input("Win: "))
  losses= int(input("Losses: "))
  ties = int(input("Ties: "))
  data = (name, win, losses, ties)
  query = '''INSERT INTO Player (name,wins,losses,ties)
             VALUES (?, ?, ?, ?)'''
  conn.execute(query, data)
  conn.commit()
  print(name.capitalize(), " was added to the database. \n")
  conn.close()

def delete():
  conn = sqlite3.connect('players_Data.db')
  name = input("name: ")
  conn.execute("DELETE FROM Player WHERE name = ?;", name)
  conn.commit()
  print("Total number of rows was deleted: ", conn.total_changes)
  cursor = conn.execute("SELECT name, wins, losses, ties FROM Player")
  for row in cursor:
    print("name = ", row[0])
    print("wins = ", row[1])
    print("losses = ", row[2])
    print("ties = ", row[3])
  print(name.capitalize(), " was deleted from the database. \n")
  conn.close()

def update():
  conn = sqlite3.connect('players_Data.db')
  name = input("name: ")
  win = int(input("win: "))
  losses= int(input("losses: "))
  ties = int(input("ties: "))
  data = (win, losses, ties, name)
  conn.execute('''UPDATE Player
                      set wins = ?,
                      losses = ?,
                      ties = ?
                WHERE name = ?;''', data)
  conn.commit()
  print ("Total number of rows updated :", conn.total_changes)
  cursor = conn.execute("SELECT name, wins, losses, ties FROM Player")
  for row in cursor:
    print ("name: ", row[0])
    print ("win: ", row[1])
    print ("losses: ", row[2])
    print ("ties: ", row[3], "\n")
    print ("Update Operation done successfully")
  conn.close()

if __name__ == '__main__':
  conn = sqlite3.connect("players_Data.db") 

  conn.execute('''
        CREATE TABLE IF NOT EXISTS Player
        (       
          playerID INTEGER PRIMARY KEY NOT NULL,
          name            TEXT         NOT NULL,
          wins            INT          NOT NULL,
          losses          INT          NOT NULL,
          ties            INT          NOT NULL
          
        )         
        ;''')

  menu()
  while True:
    command = input("Command: ")
    if command.lower() == "view":
      view()
    elif command.lower() == "add":
      add()
    elif command.lower() == "del":
      delete()
    elif command.lower() == 'update':
      update()
    elif command.lower() == "exit":
      print("Bye! ")
      break

  conn.commit()
  conn.close() 
