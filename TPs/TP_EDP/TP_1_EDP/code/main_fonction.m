clear all;
close all;
clc; 



t=[0.001 0.01 0.1 0.3] 
color='bmgr';
for i=1:4
    
    theta = 1; % On choisit soit theta=1 ou 0.5 ou 0    
    N = 50;
    Na = 101;
    G = 8.40   %  11310840
    nu = 1;
    h=1;
    s=0;
    r=0.5
    phi=0;
    y=linspace(0,h,N)';
    Ti=G*0.5*y.*(h-y);
    dy=h/(N-1);
    dt=(r*dy*dy)/nu;
    nit=t(i)/dt;
    [T]=tshema(Ti,theta,r,s,phi,nit);
    plot(T,y,color(i)) 
    legend('t = 0.001','t = 0.01','t = 0.1','t = 0.3')
    title('Vitess_nu_1 h_1')
    xlabel('la_axe_x')
    ylabel('vitess_y')
 
    hold on
end



figure
t=[0.001 0.01 0.1 0.3]
color='grby'

for i=1:4
    N=50.;
    h=1.;
    G=8.40    %  11310840
    nu=10.;
    dy=h/(N-1);
    s=0.;
    r=0.5;
    phi=0.
    y=linspace(0,h,N)';
    Ti=G*0.5*y.*(h-y);
    dt=(r*dy*dy)/nu;
    nit=t(i)/dt;
    theta=0.5;
    [T]=tshema(Ti,theta,r,s,phi,nit);
    hold on
    plot(T,y,color(i))
    legend('t=0.001','t=0.01','t=0.1','t=0.3')
    title('Vitess_nu_10_h_1')
    xlabel('la_axe_x')
    ylabel('vitess_y')
       
    
end  

figure
t=[0.001 0.01 0.1]
color='grby'

for  i=1:4
     N=100;
     h=1;
     G=8.40;    %  11310840
     nu=1;
     y=linspace(0,h,N)';
     Na=101;
     [Uex]=solution_exact(N,Na,nu,G,h,y,t);
     hold on
     plot(Uex,y)
     legend('t=0.001','t=0.01','t=0.1')
     title('Vitess_y_solution_exact')
     xlabel('la_axe_x')
     ylabel('vitess_y')
    
end
 



tnum=1;
N=50;
h=1;
G=8.40;   %  11310840
nu=1;
y=linspace(0,h,N)';
Na=101;
[Uex]=solution_exact(N,Na,nu,G,h,y,tnum);
figure
hold on
plot(Uex,y,'o-')
r=0.1;
phi=0.
dy=h/(N-1);
s=0.;
dt=(r*dy*dy)/nu;
nitnum=tnum/dt;
theta=0.5;
Ti=G*1/2*y.*(h-y);
[Tnum]=tshema(Ti,theta,r,s,phi,nitnum);
hold on; 
plot(Tnum,y,'g')
legend('Solution_u_exact','Solution_num¨¦rique_u_num')
title('solution_exact_et_simulation');
xlabel('la_axe_x') 
ylabel('vitess_y') 

hold off;

