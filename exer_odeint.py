#! /usr/bin/env python
#-*- coding:utf8 -*-

from __future__ import print_function 
from scipy.integrate import odeint
import numpy as np
import matplotlib.pyplot as plt

def exercice1(y,t):
	dydt = -y+1
	return dydt

def plot_exercice1(y0,t):
	y = odeint(exercice1,y0,t)
	plt.plot(t,y)
	plt.show()
	return

def exercice2(y,t):
	if t<10 :
		u = 0
	else :
		u = 2
	dydt = (-y+u)/5.0
	return dydt

def plot_exercice2(y0,t):
	y = odeint(exercice2,y0,t)
	plt.plot(t,y)
	plt.plot([0,10,10,50],[0,0,2,2])
	plt.show()
	return

def exercice3(z,t):
	dxdt = 3*np.exp(-t)
	dydt = 3-z[1]
	dzdt = [dxdt,dydt]
	return dzdt

def plot_exercice3(z0,t):
	z = odeint(exercice3,z0,t)
	plt.plot(t,[h+1 for h in z[:,0]])
	plt.plot(t,z[:,1],'-')
	plt.show()
	return

def exercice4(z,t):
	if t<10 :
		u = 0
	else :
		u = 2
	dxdt = (-z[0]+u)/2
	dydt = (-z[1]+z[0])/5
	dzdt = [dxdt,dydt]
	return dzdt

def plot_exercice4(z0,t):
	z = odeint(exercice4,z0,t)
	plt.plot(t,z[:,0])
	plt.plot(t,z[:,1])
	plt.plot([0,10,10,50],[0,0,2,2])
	plt.show()
	return

def exercice5(z,t):
	# z = [y ,y']
	K = 30
	dzdt = np.zeros(2)
	dzdt[0] = z[1]
	dzdt[1] = -z[1]*(0.9+0.7*t)-K*z[0]
	return dzdt 

def plot_exercice5(z0,t):
	z = odeint(exercice5,z0,t)
	plt.figure()
	plt.plot(t,z[:,0],'g*')
	plt.plot(t,z[:,1],'r:')
	plt.legend(['y','dy'],loc='upper left') # right, center right, upper right, lower centre
	plt.xlabel('time')
	# plt.xlim(-1,3)
	plt.show()
	return

def exercice6(z,x):
	# z = [y,y',y",y"']
	# z' = [y',y",y"',y""]
	dzdx = np.zeros(4)
	dzdx[0] = z[1]
	dzdx[1] = z[2]
	dzdx[2] = z[3]
	dzdx[3] = 12*z[3]-36*z[2]-512*np.exp(-2*x)
	return dzdx

def plot_exercice6(z0,x):
	z = odeint(exercice6,z0,x)
	plt.figure()
	ys = np.exp(6*x)*(3-6*x)-2*np.exp(-2*x)-3*x
	plt.plot(x,z[:,0])
	plt.plot(x,ys,'*')
	plt.legend(['y','ys'])
	plt.xlabel('x')
	plt.show()

def f(x,a):
    return 1/(1+a*x**2/4)**2













