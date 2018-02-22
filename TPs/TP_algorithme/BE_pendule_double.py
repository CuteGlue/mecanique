#! /usr/bin/env python
#-*- coding:utf8 -*-

from __future__ import print_function 
from scipy.integrate import odeint
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.animation as animation
# A.x = b
# abcd = 0840
#1 9 5 1 9.8
m1 = 1
m2 = 9
l1 = 5
l2 = 1
g = 9.8



def matrice():
    global m1,m2,l1,l2,g
    A = np.zeros((2,2))
    A[0,0] = -(m1+m2)*g/((m1+m2)*l1-m2*l1)
    A[0,1] = m2*g/((m1+m2)*l1-m2*l1)
    A[1,0] = (m1+m2)*g/((m1+m2)*l2-m2*l2)
    A[1,1] = -(m1+m2)*g/((m1+m2)*l2-m2*l2)
    return A
    
def val_propre(A):
    return np.linalg.eig(A)[0]
    
def vec_propre(A):
    return np.linalg.eig(A)[1]
    
def propre(A):
    return np.linalg.eig(A)
    
def line_modle1(A):
    D,V = np.linalg.eig(A)
    T = 2*np.pi/np.sqrt(abs(D[0]))
    t = np.linspace(0,2*T,10000)
    theta1 = V[0,0]*np.cos(np.sqrt(abs(D[0]))*t)
    theta2 = V[0,1]*np.cos(np.sqrt(abs(D[0]))*t)
    plt.plot(t,theta1)
    plt.plot(t,theta2)
    plt.legend(['theta1','theta2'],loc='upper right')
    plt.xlabel('time')
    plt.ylabel('theta')
    plt.show()
    return 
    
def line_modle2(A):
    D,V = np.linalg.eig(A)
    T = 2*np.pi/np.sqrt(abs(D[1]))
    t = np.linspace(0,2*T,10000)
    theta1 = V[1,0]*np.cos(np.sqrt(abs(D[1]))*t)
    theta2 = V[1,1]*np.cos(np.sqrt(abs(D[1]))*t)
    plt.plot(t,theta1)
    plt.plot(t,theta2)
    plt.legend(['theta1','theta2'],loc='upper right')
    plt.xlabel('time')
    plt.ylabel('theta')
    plt.show()
    return 
# y = [theta1 ,theta2, theta1',theta2']
def model_line(y,t):
    global m1,m2,l1,l2,g
    dydt = np.zeros(4)
    dydt[0] = y[2]
    dydt[1] = y[3]
    dydt[2] =(-(m1+m2)*g*y[0]+m2*g*y[1])/((m1+m2)*l1-m2*l1)
    dydt[3] =(-(m1+m2)*g*y[1]+(m1+m2)*g*y[0])/((m1+m2)*l2-m2*l2)
    return dydt

def solu_line(y0,t):
    y = odeint(model_line,y0,t)
    return y
    

def model(y,t):
    global m1,m2,l1,l2,g
    dydt = np.zeros(4)
    dydt[0] = y[2]
    dydt[1] = y[3]
    dydt[2] = (-m2*l1*y[2]**2*np.cos(y[0]-y[1])*np.sin(y[0]-y[1])-m2*l2*y[3]**2*np.sin(y[0]-y[1]))/((m1+m2)*l1-m2*l1*np.cos(y[0]-y[1])**2)+(-(m1+m2)*g*np.sin(y[0])+m2*g*np.sin(y[1])*np.cos(y[0]-y[1]))/((m1+m2)*l1-m2*l1*np.cos(y[0]-y[1])**2)
    dydt[3] = ((m1+m2)*l1*y[2]**2*np.sin(y[0]-y[1])+m2*l2*y[3]**2*np.cos(y[0]-y[1])*np.sin(y[0]-y[1]))/((m1+m2)*l2-m2*l2*np.cos(y[0]-y[1])**2)+(-(m1+m2)*g*np.sin(y[1])+(m1+m2)*g*np.sin(y[0])*np.cos(y[0]-y[1]))/((m1+m2)*l2-m2*l2*np.cos(y[0]-y[1])**2)
    return dydt


def chaos_1(y0,t):
    global l1,l2
    y = odeint(model,y0,t)
    return y

def chaos_2(y0,t):
    global l1,l2
    y = odeint(model,y0,t)
    x1,y1 = l1*np.sin(y[:,0]),-l1*np.cos(y[:,0])
    x2,y2 = x1+l2*np.sin(y[:,1]),y1-l2*np.cos(y[:,1])
    return y,x1,y1,x2,y2

def model_f(y,t,a,w):
    global m1,m2,l1,l2,g
    dydt = np.zeros(4)
    dydt[0] = y[2]
    dydt[1] = y[3]
    dydt[2] = (-m2*l1*y[2]**2*np.cos(y[0]-y[1])*np.sin(y[0]-y[1])-m2*l2*y[3]**2*np.sin(y[0]-y[1]))/((m1+m2)*l1-m2*l1*np.cos(y[0]-y[1])**2)+(-(m1+m2)*g*np.sin(y[0])+m2*g*np.sin(y[1])*np.cos(y[0]-y[1])-a*np.cos(w*t))/((m1+m2)*l1-m2*l1*np.cos(y[0]-y[1])**2)
    dydt[3] = ((m1+m2)*l1*y[2]**2*np.sin(y[0]-y[1])+m2*l2*y[3]**2*np.cos(y[0]-y[1])*np.sin(y[0]-y[1]))/((m1+m2)*l2-m2*l2*np.cos(y[0]-y[1])**2)+(-(m1+m2)*g*np.sin(y[1])+(m1+m2)*g*np.sin(y[0])*np.cos(y[0]-y[1])+a*np.cos(w*t)*np.cos(y[0]-y[1]))/((m1+m2)*l2-m2*l2*np.cos(y[0]-y[1])**2)
    return dydt
    
def solu_f(y0,t,a,w):
    y = odeint(model_f,y0,t,args=(a,w,))
    return y

def energie(y0,t):
    global l1,l2,m1,m2
    y = odeint(model,y0,t)
    T = (1/2)*m1*l1**2*y[:,2]**2+(1/2)*m2*(l1**2*y[:,2]**2+l2**2*y[:,3]**2)+m2*l1*l2*y[:,2]*(y[:,3]*np.cos(y[:,0]-y[:,1]))
    U = -(m1+m2)*g*l1*np.cos(y[:,0])-m2*g*l2*np.cos(y[:,1])
    L = T-U
    return L,T,U





