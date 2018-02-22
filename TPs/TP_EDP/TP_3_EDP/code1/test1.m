% equation des ondes en polaire
% schema explicite
clear;
Nx=101; 
Ny=Nx;
dx=2/(Nx-1);
dy=2/(Ny-1);
X=[-1:dx:1]';
Y=[-1:dy:1];
% parametre
c0=1.;
CFL=0.5;
dt=CFL*dx/c0;
omega=14.0;
g=9.8;
A=0.2;
% initialisation
Un0=zeros(Nx,Ny);
Un=Un0;
Un1=Un;
% noeuds internes
I=[2:Nx-1];
J=[2:Ny-1];
fact=Un(1,:);
% schema D.F.
Tf=8.0;   %t final de la simulation
nit= Tf/dt;     %no. de pas de temps
% xi sur ид (0,0)
Uaxe=zeros(nit+1,1);
Uaxe(1)=0.0;
figure(1);
surf(X,Y,Un(:,:)); axis([-1 1 -1 1 -1 1]);%shading interp;
% iteration
for it=1:nit
   drawnow;
   coef=c0^2*dt^2;
   clterm=A*2*dx*cos(omega*it*dt);
   if (it==1) 
       coef=coef/2;
   end;
   % noeuds internes
   Un1(I,J)=2*Un(I,J)-Un0(I,J) + CFL^2*(Un(I+1,J)-2*Un(I,J)+Un(I-1,J)) + CFL^2*(Un(I,J+1)-2*Un(I,J)+Un(I,J-1));

   % C.L.
   Un1(1,J)=2*Un(1,J)-Un0(1,J) + CFL^2*(Un(2,J)-2*Un(1,J)+Un(2,J)+clterm)+ CFL^2*(Un(1,J+1)-2*Un(1,J)+Un(1,J-1));

   Un1(Nx,J)=2*Un(Nx,J)-Un0(Nx,J) + CFL^2*(Un(Nx-1,J)-2*Un(Nx,J)+Un(Nx-1,J)-clterm) + CFL^2*(Un(Nx,J+1)-2*Un(Nx,J)+Un(Nx,J-1));

   Un1(I,1)=2*Un(I,1)-Un0(I,1) + CFL^2*(Un(I+1,1)-2*Un(I,1)+Un(I-1,1)) + CFL^2*(Un(I,2)-2*Un(I,1)+Un(I,2)+clterm);

   Un1(I,Ny)=2*Un(I,Ny)-Un0(I,Ny) + CFL^2*(Un(I+1,Ny)-2*Un(I,Ny)+Un(I-1,Ny)) + CFL^2*(Un(I,Ny-1)-2*Un(I,Ny)+Un(I,Ny-1)-clterm);
   
   for a=2:40
        Un1(1,a)=2*Un(1,a)-Un0(1,a) + CFL^2*(Un(2,a)-2*Un(1,a)+Un(2,a))+ CFL^2*(Un(1,a+1)-2*Un(1,a)+Un(1,a-1));
   end
   
   for a=62:100
       Un1(1,a)=2*Un(1,a)-Un0(1,a) + CFL^2*(Un(2,a)-2*Un(1,a)+Un(2,a))+ CFL^2*(Un(1,a+1)-2*Un(1,a)+Un(1,a-1));
   end
   
   for a=2:40
        Un1(100,a)=2*Un(100,a)-Un0(100,a) + CFL^2*(Un(101,a)-2*Un(100,a)+Un(101,a))+ CFL^2*(Un(100,a+1)-2*Un(100,a)+Un(100,a-1));
   end
   
    for a=62:100
        Un1(100,a)=2*Un(100,a)-Un0(100,a) + CFL^2*(Un(101,a)-2*Un(100,a)+Un(101,a))+ CFL^2*(Un(100,a+1)-2*Un(100,a)+Un(100,a-1));
    end
    for a=2:40
        Un1(a,1)=2*Un(a,1)-Un0(a,1) + CFL^2*(Un(a,2)-2*Un(a,1)+Un(a,2))+ CFL^2*(Un(a+1,1)-2*Un(a,1)+Un(a-1,1));
   end
   
   for a=62:100
       Un1(a,1)=2*Un(a,1)-Un0(a,1) + CFL^2*(Un(a,2)-2*Un(a,1)+Un(a,2))+ CFL^2*(Un(a+1,1)-2*Un(a,1)+Un(a-1,1));
   end
   
   for a=2:40
        Un1(a,100)=2*Un(a,100)-Un0(a,100) + CFL^2*(Un(a,101)-2*Un(a,100)+Un(a,101))+ CFL^2*(Un(a+1,100)-2*Un(a,100)+Un(a-1,100));
   end
   
    for a=62:100
        Un1(a,100)=2*Un(a,100)-Un0(a,100) + CFL^2*(Un(a,101)-2*Un(a,100)+Un(a,101))+ CFL^2*(Un(a+1,100)-2*Un(a,100)+Un(a-1,100));
    end
       
   
 % four points
   
   Un1(1,1)=2*Un(1,1)-Un0(1,1) + CFL^2*(Un(1+1,1)-2*Un(1,1)+Un(2,1)) + CFL^2*(Un(1,1+1)-2*Un(1,1)+Un(1,2));

   Un1(1,Ny)=2*Un(1,Ny)-Un0(1,Ny) + CFL^2*(Un(1+1,Ny)-2*Un(1,Ny)+Un(2,Ny)) + CFL^2*(Un(1,Ny-1)-2*Un(1,Ny)+Un(1,Ny-1));

   Un1(Nx,1)=2*Un(Nx,1)-Un0(Nx,1) + CFL^2*(Un(Nx-1,1)-2*Un(Nx,1)+Un(Nx-1,1)) + CFL^2*(Un(Nx,2)-2*Un(Nx,1)+Un(Nx,2));

   Un1(Nx,Ny)=2*Un(Nx,Ny)-Un0(Nx,Ny) + CFL^2*(Un(Nx-1,Ny)-2*Un(Nx,Ny)+Un(Nx-1,Ny)) + CFL^2*(Un(Nx,Ny-1)-2*Un(Nx,Ny)+Un(Nx,Ny-1));

   Uaxe(it+1)=Un1(51,51);

   % iteration suivante
   Un0=Un; 
   Un=Un1;
   % trace solution
   surf(X,Y,Un1(:,:)); axis([-1 1 -1 1 -1 1]);shading interp;
end;

% evolution sur x=0 y=0
figure(2);
plot([1:nit+1]*dt,Uaxe,'b');