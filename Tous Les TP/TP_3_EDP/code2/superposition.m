% equation des ondes
% schema explicite
clear all;
close all


Nx=401;
Ny=401;
dx=2/(Nx-1);
dy=2/(Ny-1);
X=[-1:dx:1]';
Y=[-1:dy:1];
% parametre
c0=1;
CFL=0.5 ;
dt=CFL*dx/c0;
%  cdts initial
lambda1=fzero(inline('-besselj(1,r)'),10);   % lambda1 = racine de F0
BJ1=inline('besselj(0,r)','r');
for i = 1:Nx
     W(i,:)=BJ1(lambda1*sqrt(X(i)*X(i)+Y(:).*Y(:)));
     
end
W1=BJ1(lambda1*sqrt(X(round(Nx/2))*X(round(Nx/2))+Y(round(Ny/2+0.1/dy))*Y(round(Ny/2+0.1/dy))));
W2=BJ1(lambda1*sqrt(X(round(Nx/2))*X(round(Nx/2))+Y(round(Ny/2-0.1/dy))*Y(round(Ny/2-0.1/dy))));
W(round(Nx/2),round(Nx/2))=(W1+W2);
% initialisation
Un0=zeros(Nx,Ny);
Un0(:,:)=W; 
Un=Un0;
Un1=Un;
% noeuds internes
I=[2:Nx-1];    % des noeuds sauf frontiere
J=[2:Ny-1];
% schema D.F.
Tfinal=1;
nit=round(Tfinal/dt);
% xi sur (x,y)=(0,0)
Uaxe=zeros(nit+1,1);
Uaxe(1)= Un(round(Nx/2),round(Ny/2));
figure(1);
surf(X,Y,Un(:,:)); axis([-1 1 -1 1 -1 1]);
% iteration
for it=1:nit
   drawnow;
   coef=c0^2*dt^2;
   if (it==1) 
       coef=coef/2;
   end;
   % noeuds internes
   
   Un1(I,J)=2*Un(I,J)-Un0(I,J) + CFL^2*(Un(I+1,J)-2*Un(I,J)+Un(I-1,J))+CFL^2*(Un(I,J+1)-2*Un(I,J)+Un(I,J-1)) ;                       %Un1 =h n+1, Un=hn, Un0=hn-1
            
  % C.L.
   Un1(1,J)=2*Un(1,J)-Un0(1,J) +  CFL^2*(Un(1+1,J)-2*Un(1,J)+Un(2,J))+CFL^2*(Un(1,J+1)-2*Un(1,J)+Un(1,J-1)) ;    % condition miroir I=1,0=2
            
   Un1(Nx,J)=2*Un(Nx,J)-Un0(Nx,J) + CFL^2*(Un(Nx-1,J)-2*Un(Nx,J)+Un(Nx-1,J))+CFL^2*(Un(Nx,J+1)-2*Un(Nx,J)+Un(Nx,J-1)) ;  % condition miroir I=Nx, Nx+1 = Nx-1
            
   Un1(I,1)=2*Un(I,1)-Un0(I,1) + CFL^2*(Un(I+1,1)-2*Un(I,1)+Un(I-1,1))+CFL^2*(Un(I,1+1)-2*Un(I,1)+Un(I,2)) ;  
            
   Un1(I,Ny)=2*Un(I,Ny)-Un0(I,Ny) + CFL^2*(Un(I+1,Ny)-2*Un(I,Ny)+Un(I-1,Ny))+CFL^2*(Un(I,Ny-1)-2*Un(I,Ny)+Un(I,Ny-1)) ;  
            
   % iteration suivante
   Uaxe(it+1)= Un(round(Nx/2),round(Ny/2));
   Un0=Un; 
   Un=Un1;
   % trace solution
   surf(X,Y,Un1(:,:)); axis([-1 1 -1 1 -1 1]);shading interp;
end;
% evolution sur l'axe
figure(2);
plot([1:nit+1]*dt,Uaxe);
xlabel('t')
ylabel('h')
title('h au centre du domaine en fonction du temps dans le cas superposition')
legend('Nx=Ny=401')
