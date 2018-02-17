% equation des ondes
% schema explicite
clear all;
close all
% parametre  
c0=1;
Nx=201; 
Ny=201;
dx=2/(Nx-1);
dy=2/(Ny-1);
X=[-1:dx:1]';
Y=[-1:dy:1];

CFL=[ 0.3 0.5 0.6 0.7 0.8 0.9 1 1.1 ];     %0.05, 0.1, 0.3, 
for i = 1:length(CFL)
    
    dt=CFL(i)*dx/c0;
%  cdts initial
    lambda1=fzero(inline('-besselj(1,r)'),10);   % lambda1 = racine de F0
    BJ1=inline('besselj(0,r)','r');
    for k = 1:Nx
        for j =1:Ny
            W(k,j)=BJ1(lambda1*sqrt(X(k)*X(k)+Y(j)*Y(j)));
        end
    end
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
%     figure(1);
%     surf(X,Y,Un(:,:)); axis([-1 1 -1 1 -1 1]);
% iteration
    for it=1:nit
        drawnow;
        coef=c0^2*dt^2;
        if (it==1)
            coef=coef/2;
        end;
   % noeuds internes
    Un1(I,J)=2*Un(I,J)-Un0(I,J) + CFL(i)^2*(Un(I+1,J)-2*Un(I,J)+Un(I-1,J))+CFL(i)^2*(Un(I,J+1)-2*Un(I,J)+Un(I,J-1)) ;                       %Un1 =hn+1, Un=hn, Un0=hn-1
            
  % C.L.
    Un1(1,J)=2*Un(1,J)-Un0(1,J) +  CFL(i)^2*(Un(1+1,J)-2*Un(1,J)+Un(2,J))+CFL(i)^2*(Un(1,J+1)-2*Un(1,J)+Un(1,J-1)) ;    % condition miroir I=1,0=2
            
    Un1(Nx,J)=2*Un(Nx,J)-Un0(Nx,J) + CFL(i)^2*(Un(Nx-1,J)-2*Un(Nx,J)+Un(Nx-1,J))+CFL(i)^2*(Un(Nx,J+1)-2*Un(Nx,J)+Un(Nx,J-1)) ;  % condition miroir I=Nx, Nx+1 = Nx-1
            
    Un1(I,1)=2*Un(I,1)-Un0(I,1) + CFL(i)^2*(Un(I+1,1)-2*Un(I,1)+Un(I-1,1))+CFL(i)^2*(Un(I,1+1)-2*Un(I,1)+Un(I,2)) ;  
            
    Un1(I,Ny)=2*Un(I,Ny)-Un0(I,Ny) + CFL(i)^2*(Un(I+1,Ny)-2*Un(I,Ny)+Un(I-1,Ny))+CFL(i)^2*(Un(I,Ny-1)-2*Un(I,Ny)+Un(I,Ny-1)) ;  
            
   % iteration suivanteEZXSR
    Uaxe(it+1)= Un(round(Nx/2),round(Ny/2));   % Uaxe est la valeur numerique au centre du domaine en fonction de t, c'est un vecteur
    Un0=Un; 
    Un=Un1;
   % trace solution
    %surf(X,Y,Un1(:,:)); axis([-1 1 -1 1 -1 1]);shading interp;
    end
    
     plot([1:nit+1]*dt,Uaxe);
     hold all
    
    %soluton analytique au centre du domaine
    tt=0:dt:1 ;
    Ecart=zeros(1,length(tt));
    for ii=1:length(tt)
         Ua(ii)=cos(c0*lambda1*tt(ii));
         Ecart(ii)=abs(Ua(ii)-Uaxe(ii));
    end
    Err(i)=max(Ecart);
    
end;
legend('CFL=0.3','CFL=0.5','CFL=0.6','CFL=0.7','CFL=0.8','CFL=0.9','CFL=1','CFL=1.1'); 
xlabel('t'); ylabel('h');
title('h(x,y,t)) au centre du domaine pour Nx=Ny=201')
%evolution sur l'axe



%% tracer Erreur en fonction de Nx=Ny
figure (2)
plot(log(CFL),log(Err),'*-');
xlabel(' log(CFL)'); ylabel('log(Erreur)');
title('Erreur au centre du domaine en fonction de CFL en log-log')
Pente = (log(Err(4))-log(Err(1)))/(log(CFL(4))-log(CFL(1)))
