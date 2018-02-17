%ZHANG Xunjie                                                         
% Numero etudiant : 11310840                                                 
% Groupe 3                                                                
% TP 2 , equantion de transport     

clear all
close all
clc

%% Les conditions et donnes
k=37.;
alpha=-2.*k*tan(k/2);
Po=cos(k/2)*exp(-alpha/4);
L=1.;
N=300;
x=linspace(-L,2*L,N);
c=1.; 
phi=0.;
t0=0.8*L/c;
t=t0;
CFL=[0.1,1.0];
dx=3.*L/(N-1);
dt=CFL*dx/c;

L=1.0;
N=300;
k=37.0;
alpha=(-2.0)*k*tan(k/2);
x=linspace(-L,2*L,N);
c=1;
t=0.8; 
dx=3*L/(N-1);
CFL=[0.1,1.0];
dt=[CFL(1)*dx/c,CFL(2)*dx/c];
nit=[t/dt(1),t/dt(2)];
Pi=Solutexact(x,k,alpha,c,0.,N);
pex=Solutexact(x,k,alpha,c,t,N);

%% Solution exact
%[Pi]=Solutexact(x,k,alpha,c,0.,N);
%[Pe]=Solutexact(x,k,alpha,c,t,N);
%% Schema de Courant
color = hsv(length(CFL)+1);
figure(2)
plot (x,Pex,'Color',color(1,:));
hold on;
legendInfo{1}=['Cond Init'];
for i = 1:length(CFL)
    nit=t/dt(i);
    [P1]=courant(Pi,CFL(i),nit);
    plot (x,P1,'Color',color(i+1,:));
    xlabel('P(x,t)');ylabel('x')
    title('Solutions de courant schema ид t=t0','FontSize', 10)
    legendInfo{i+1} = ['CFL = ' num2str(CFL(i))];
end
legend(legendInfo,'Location','northwest')
grid on
print('-r150','-f2','courant','-dpng')
hold off;



