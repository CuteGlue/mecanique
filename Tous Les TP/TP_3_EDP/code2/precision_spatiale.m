% equation des ondes
% schema explicite
clear all;
close all

Nx=[51 101 201 401 801]; 
Ny=[51 101 201 401 801];
for i = 1:length(Nx)
    dx=2/(Nx(i)-1);
    dy=2/(Ny(i)-1);
    X=[-1:dx:1]';
    Y=[-1:dy:1];
% parametre
    c0=1;
    CFL=0.5 ;
    dt=CFL*dx/c0;
%  cdts initial
    lambda1=fzero(inline('-besselj(1,r)'),10);   % lambda1 = racine de F0
    BJ1=inline('besselj(0,r)','r');
    for k = 1:Nx(i)
        for j =1:Ny(i)
            W(k,j)=BJ1(lambda1*sqrt(X(k)*X(k)+Y(j)*Y(j)));
        end
    end
% initialisation
    Un0=zeros(Nx(i),Ny(i));
    Un0(:,:)=W; 
    Un=Un0;
    Un1=Un;
% noeuds internes
    I=[2:Nx(i)-1];    % des noeuds sauf frontiere
    J=[2:Ny(i)-1];
% schema D.F.
    Tfinal=1;
    nit=round(Tfinal/dt);
% xi sur (x,y)=(0,0)
    Uaxe=zeros(nit+1,1);
    Uaxe(1)= Un(round(Nx(i)/2),round(Ny(i)/2));
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
    Un1(I,J)=2*Un(I,J)-Un0(I,J) + CFL^2*(Un(I+1,J)-2*Un(I,J)+Un(I-1,J))+CFL^2*(Un(I,J+1)-2*Un(I,J)+Un(I,J-1)) ;                       %Un1 =hn+1, Un=hn, Un0=hn-1
            
  % C.L.
    Un1(1,J)=2*Un(1,J)-Un0(1,J) +  CFL^2*(Un(1+1,J)-2*Un(1,J)+Un(2,J))+CFL^2*(Un(1,J+1)-2*Un(1,J)+Un(1,J-1)) ;    % condition miroir I=1,0=2
            
    Un1(Nx(i),J)=2*Un(Nx(i),J)-Un0(Nx(i),J) + CFL^2*(Un(Nx(i)-1,J)-2*Un(Nx(i),J)+Un(Nx(i)-1,J))+CFL^2*(Un(Nx(i),J+1)-2*Un(Nx(i),J)+Un(Nx(i),J-1)) ;  % condition miroir I=Nx, Nx+1 = Nx-1
            
    Un1(I,1)=2*Un(I,1)-Un0(I,1) + CFL^2*(Un(I+1,1)-2*Un(I,1)+Un(I-1,1))+CFL^2*(Un(I,1+1)-2*Un(I,1)+Un(I,2)) ;  
            
    Un1(I,Ny(i))=2*Un(I,Ny(i))-Un0(I,Ny(i)) + CFL^2*(Un(I+1,Ny(i))-2*Un(I,Ny(i))+Un(I-1,Ny(i)))+CFL^2*(Un(I,Ny(i)-1)-2*Un(I,Ny(i))+Un(I,Ny(i)-1)) ;  
            
   % iteration suivanteEZXSR
    Uaxe(it+1)= Un(round(Nx(i)/2),round(Ny(i)/2));   % Uaxe est la valeur numerique au centre du domaine en fonction de t, c'est un vecteur
    Un0=Un; 
    Un=Un1;
   % trace solution
    %surf(X,Y,Un1(:,:)); axis([-1 1 -1 1 -1 1]);shading interp;
    end
    
    plot([1:nit+1]*dt,Uaxe);
    hold all
    
    %Calcul de la soluton analytique et l'erreur au centre du domaine
    tt=0:dt:1 ;
    Ecart=zeros(1,length(tt));
    for ii=1:length(tt)
         Ua(ii)=BJ1(0)*cos(c0*lambda1*tt(ii));
         Ecart(ii)=abs(Ua(ii)-Uaxe(ii));
    end
    Err(i)=max(Ecart);
    
end;
plot([1:nit+1]*dt,Ua,'--k'); 
legend('Nx=51','Nx=101','Nx=201','Nx=401','Nx=801','Hexact');
xlabel('t'); ylabel('h');
title('h(x=0,y=0,t) en fonction du temps')


   
%% tracer Erreur en fonction de Nx=Ny
figure (2)
plot(log(Nx),log(Err),'*-');
xlabel(' log(Nx)'); ylabel('log(Erreur)');
title('Erreur au centre du domaine en fonction de Nx=Ny en log-log')
Pente = polyfit(log(Nx),log(Err),1) ;


