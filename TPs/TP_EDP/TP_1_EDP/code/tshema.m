function [T]=tshema(Ti,theta,r,s,phi,nit)
% calcul de la solution T équation de chaleur avec source du theta-schema
% Ti=solution initiale
% theta,r,s,phi parametres du shema
% nit= nbre de pas d'integration
% methode de Thomas avec tridiag
N=length(Ti);
% matrices 3 Diag
e=ones(1,N);
A = [((-1)*(1-theta)*r)*e; (1+2*r*(1-theta))*e; ((-1)*(1-theta)*r)*e];
C = [(theta*r)*e; (1-2*r*theta)*e; (theta*r)*e];
% cl
A(:,1) =0;
A(2,1)=1; 
C(:,1)=0; 
C(2,1)=1;
A(:,N)=0; 
A(2,N)=1; 
C(:,N)=0; 
C(2,N)=1;
% solution initiale
T=Ti;
% iterations

for it = 1:nit
B=C(1,1:N)'.*[0;T(1:N-1)]+C(2,1:N)'.*T(1:N)+C(3,1:N)'.*[T(2:N);0];
B(N)=B(N)+phi;
T=tridiag(A,B);
end
