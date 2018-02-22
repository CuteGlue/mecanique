
%% ZHANG XUNJIE
% 11310840


%% Les parametres
clear all
clc
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
Pi=Solutexact(k,alpha,N,L,c,0);
pex=Solutexact(k,alpha,N,L,c,t);

%% Solution exact
figure(1)
plot(x,pex,'b')
xlabel('x')
ylabel('P(x,t0)')
title('La solution analytique ¨¤ t=t0 ')
legend('solution analytique')




%% Courant schema
p1=courant(Pi,CFL(1),nit(1));
p2=courant(Pi,CFL(2),nit(2));
%X=x-c*t;
%p12=courant(Pi,CFL(1),nit(1));
%p2=leapfrog(Pi,CFL(2),nit(2));
%p3=laxwendroff(Pi,CFL,nit);
figure(2)
plot(x,pex,'b')
hold on
plot(x,p1,'r')
hold on
plot(x,p2,'g')
%plot(x,p2,'g')
%plot(x,p3,'b')
%ylim([-1.1, +1.2]);
xlabel('x')
ylabel('P(x,t0)')
title('Les solutions num¨¦riques et analytique ¨¤ t=t0 ')
legend('Solution exacte','Schema courant CFL=0.1','Schema courant CFL=1.0');
hold off
%xlabel('log(N)'); ylabel('log(Erreur)');
%pente=polyfit(log(N),log(err),1);  


%% laxwendroff schema
p1=laxwendroff(Pi,CFL(1),nit(1));
p2=laxwendroff(Pi,CFL(2),nit(2));
%X=x-c*t;
%p12=courant(Pi,CFL(1),nit(1));
%p2=leapfrog(Pi,CFL(2),nit(2));
%p3=laxwendroff(Pi,CFL,nit);
figure(3)
plot(x,pex,'b')
hold on
plot(x,p1,'r')
hold on
plot(x,p2,'g')
%plot(x,p2,'g')
%plot(x,p3,'b')
%ylim([-1.1, +1.2]);
xlabel('x')
ylabel('P(x,t0)')
title('Les solutions num¨¦riques et analytique ¨¤ t=t0 ')
legend('Solution exacte','Schema laxwendroff CFL=0.1','Schema laxwendroff CFL=1.0');
hold off


%% leapfrog schema
p_1=leapfrog(Pi,CFL(1),nit(1));
p_2=leapfrog(Pi,CFL(2),nit(2));
%X=x-c*t;
%p12=courant(Pi,CFL(1),nit(1));
%p2=leapfrog(Pi,CFL(2),nit(2));
%p3=laxwendroff(Pi,CFL,nit);
figure(4)
plot(x,pex,'b')
hold on
plot(x,p_1,'r')
hold on
plot(x,p_2,'g')
%plot(x,p2,'g')
%plot(x,p3,'b')
%ylim([-1.1, +1.2]);
xlabel('x')
ylabel('P(x,t0)')
title('Les solutions num¨¦riques et analytique ¨¤ t=t0 ')
legend('Solution exacte','Schema leapfrog CFL=0.1','Schema leapfrog CFL=1.0');
hold off

%% calculer error spatial
N1=[500,600,1000,2000,3000,6000];
En1=zeros(length(N1),1);
En2=zeros(length(N1),1);
En3=zeros(length(N1),1);
for i=1:length(N1)
    x1=linspace(-L,2*L,N1(i));
%   dx1=x1(2)-x1(1);
    dx1=3*L/(N1(i)-1);
    Pi1=Solutexact(k,alpha,N,L,c,0);
    pex1=Solutexact(k,alpha,N,L,c,t);
    dt1=CFL(1)*dx1/c ;
    nit1=t/dt1 ;
    p1=courant(Pi1,CFL(1),nit1);
    p2=laxwendroff(Pi1,CFL(1),nit1);
    p3=leapfrog(Pi1,CFL(1),nit1);
    
    sommecou=abs(p1-pex1);
    sommelaxwed=abs(p2-pex1);
    sommeleap=abs(p3-pex1);
    
    En1(i)=dx1*sum(sommecou) ;   
    En2(i)=dx1*sum(sommelaxwed) ;    
    En3(i)=dx1*sum(sommeleap);
end
figure(5)
plot(log(N1),log(En1),'-r',log(N1),log(En2),'-g' ,log(N1),log(En3),'-b')
xlabel('log(N)'); ylabel('log(En)');
title('Erreur en fonction de N en log-log pour CFL=0.1');
legend('Schema courant','Schema Lax Wendroff','Schema leapfrog');


 pente_courant1= polyfit(log(N1),log(En1'),1);
 pente_laxwendroff1 = polyfit(log(N1),log(En2'),1);
 pente_leapfrog1 = polyfit(log(N1),log(En3'),1);
 
 %%  calcul error temporelle
N2=300;
dt2=0.001:0.0005:0.01;
En1=zeros(length(dt2),1);
En2=zeros(length(dt2),1);
En3=zeros(length(dt2),1);
x2=linspace(-L,L,N2);
dx2=3*L/(N2-1);
CFL2=zeros(length(dt2),1);
Pi2=Solutexact(k,alpha,N2,L,c,0);
 
for i=1:length(dt2)
    CFL2(i)=c*dt2(i)/dx2 ;
     nit2=t/dt2(i) ;
     pex2=Solutexact(k,alpha,N2,L,c,t);
     p1=courant(Pi2,CFL2(i),nit2);
     p2=laxwendroff(Pi2,CFL2(i),nit2);
     p3=leapfrog(Pi2,CFL2(i),nit2) ;
     Ecart1=abs(p1-pex2);
     Ecart2=abs(p2-pex2);
     Ecart3=abs(p3-pex2);
     En11(i)=dx2*sum(Ecart1) ;   
     En22(i)=dx2*sum(Ecart2) ;    
     En33(i)=dx2*sum(Ecart3);
 end
 
figure(6)
plot(log(CFL2),log(En11),'-r',log(CFL2),log(En22),'-g',log(CFL2),log(En33),'-b')
xlabel('log(CFL)'); ylabel('log(En)');
title('Precision temporelle des sch¨¦mas en fonction de CFL en log-log pour N=300');
legend('Schema courant','Schema Lax Wendroff','Schema leapfrog');
pente_courant2 = polyfit(log(CFL2),log(En11'),1);
pente_laxwendroff2 = polyfit(log(CFL2),log(En22'),1);
pente_leapfrog2 = polyfit(log(CFL2),log(En33'),1);