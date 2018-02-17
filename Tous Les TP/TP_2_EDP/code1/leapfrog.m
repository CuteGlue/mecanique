function [P]=leapfrog(Pi,CFL,nit)
% Pi=solution initiale
% th,phi parametres du shema
% nit= nbre de pas d'integration
% methode de Thomas avec tridiag
N=length(Pi);
% matrices 3 Diag
e=ones(1,N);
A=[0*e; 1*e; 0*e];
C=[CFL*e; 1*e; -CFL*e];
% C.L dirichlet en 1, Neuman en N (cdt miroir)
A(:,1)=0 ; A(2,1)=1; C(:,1)=0 ; C(2,1)=1; 
A(1,N)= 2*A(1,N); A(3,N)=0; C(1,N)=2*C(1,N); C(3,N)=0;
% Solution initiale
P_0=Pi; %On stock la solution initiale dans p0
P_ant=P_0; %Panterieur copie les valeurs de P0
P_1=courant(P_0,CFL,1); %P1 donnï¿?par la fonction de courant
P=P_1;%On lance le calcul pour P
% iterations
for it = 2:nit
    B=C(1,1:N)'.*[0;P(1:N-1)]+C(2,1:N)'.*P_ant(1:N)+C(3,1:N)'.*[P(2:N);0];
    P_ant=P;
    P=tridiag(A,B);
    
end