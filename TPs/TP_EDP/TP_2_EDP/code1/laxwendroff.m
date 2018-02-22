function [P]=laxwendroff(Pi,CFL,nit)
N=length(Pi);
% matrices 3 Diag
e=ones(1,N);
A=[0*e; 1*e; 0*e];
C=[(CFL/2+CFL*CFL/2)*e; (1-CFL*CFL)*e; (-CFL/2+CFL*CFL/2)*e];
% C.L dirichlet en 1, Neuman en N (cdt miroir)
A(:,1) =0; A(2,1)=1; C(:,1)=0; C(2,1)=1;
A(1,N)=2*A(1,N); A(3,N)=0; C(1,N)=2*C(1,N); C(3,N)=0;
% solution initiale
P=Pi;
% iterations
for it = 1:nit
B=C(1,1:N)'.*[0;P(1:N-1)]+C(2,1:N)'.*P(1:N)+C(3,1:N)'.*[P(2:N);0];
P=tridiag(A,B);
end

