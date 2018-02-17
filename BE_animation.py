#! /usr/bin/env python
#-*- coding:utf8 -*-

from __future__ import print_function 
from scipy.integrate import odeint
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.animation as animation
# A.x = b
# abcd = 0840
m1 = 1
m2 = 9
l1 = 5
l2 = 1
g = 9.8


def model(y,t):
    global m1,m2,l1,l2,g
    dydt = np.zeros(4)
    dydt[0] = y[2]
    dydt[1] = y[3]
    dydt[2] = (-m2*l1*y[2]**2*np.cos(y[0]-y[1])*np.sin(y[0]-y[1])-m2*l2*y[3]**2*np.sin(y[0]-y[1]))/((m1+m2)*l1-m2*l1*np.cos(y[0]-y[1])**2)+(-(m1+m2)*g*np.sin(y[0])+m2*g*np.sin(y[1])*np.cos(y[0]-y[1]))/((m1+m2)*l1-m2*l1*np.cos(y[0]-y[1])**2)
    dydt[3] = ((m1+m2)*l1*y[2]**2*np.sin(y[0]-y[1])+m2*l2*y[3]**2*np.cos(y[0]-y[1])*np.sin(y[0]-y[1]))/((m1+m2)*l2-m2*l2*np.cos(y[0]-y[1])**2)+(-(m1+m2)*g*np.sin(y[1])+(m1+m2)*g*np.sin(y[0])*np.cos(y[0]-y[1]))/((m1+m2)*l2-m2*l2*np.cos(y[0]-y[1])**2)
    return dydt

def test(y0,t):
    global l1,l2
    y = odeint(model,y0,t)
    x1,y1 = l1*np.sin(y[:,0]),-l1*np.cos(y[:,0])
    x2,y2 = x1+l2*np.sin(y[:,1]),y1-l2*np.cos(y[:,1])
    return x1,y1,x2,y2,y

y0 = [0,np.pi/4,0,0]
dt = 0.05
t = np.arange(0,20,dt)
x1,y1,x2,y2,y = test(y0,t)

fig = plt.figure()
ax = fig.add_subplot(111, autoscale_on=False, xlim=(-l1-l2-0.5, l1+l2+0.5), ylim=((-l1-l2-0.5, l1+l2+0.5)))
ax.grid()

line, = ax.plot([], [], 'o-', lw=2)
time_template = 'time = %.1fs'
time_text = ax.text(0.05, 0.9, '', transform=ax.transAxes)


def init():
    line.set_data([], [])
    time_text.set_text('')
    return line, time_text


def animate(i):
    thisx = [0, x1[i], x2[i]]
    thisy = [0, y1[i], y2[i]]

    line.set_data(thisx, thisy)
    time_text.set_text(time_template % (i*dt))
    return line, time_text

ani = animation.FuncAnimation(fig, animate, np.arange(1, len(y)),
                              interval=25, blit=True, init_func=init)

# ani.save('double_pendulum.mp4', fps=15)
plt.show()