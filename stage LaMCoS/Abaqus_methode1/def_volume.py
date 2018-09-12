# -*- coding: utf-8 -*-
"""
Created on Wed Jul 25 14:24:26 2018

@author: xzhang
"""
import numpy as np
f = open("C:/Temp/strain.rpt",'r')
for i in range(19):
    a = f.readline()
E11 = []
a = f.readline().split()

while a != []:    
    b = list(map(eval,a))
    E11.append(b[1])
    a = f.readline().split()
    
for i in range(15):
    a = f.readline()

a = f.readline().split()

while a != []:    
    b = list(map(eval,a))
    E11.append(b[1])
    a = f.readline().split()
    
f.close() 

#E11 = np.asarray(E11)

f = open("C:/Temp/volume.rpt",'r')
for i in range(19):
    a = f.readline()
volume = []
a = f.readline().split()

while a != []:    
    b = list(map(eval,a))
    volume.append(b[1])
    a = f.readline().split()
    
for i in range(15):
    a = f.readline()

a = f.readline().split()

while a != []:    
    b = list(map(eval,a))
    volume.append(b[1])
    a = f.readline().split()
    
f.close() 
somme = np.dot(volume,E11)
E11_moy = somme/np.linalg.norm(volume)
print(somme,E11_moy,sum(volume))





