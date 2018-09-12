% ---------MAIN--------------------------------------------------------
tic ;
clc ;
close all ;
clear all ;

% E11_N = zeros(8,8) ; ;
% x1 = [4 16 32 64 128 256 512 1024];
% x2 = linspace(0.1,10,8) ;
% for ite_N = 1:1 
%     for ite_k = 1:1
%         N = x1(ite_N);
%         k = x2(ite_k) ;

make_pixel(4,4,0.1) ;
im = imread('figure_pixel.png') ;

% ---------COEFFICIENTS-------------------------------------------------------
E1 = 70e9 ;     %  E1 = Em
E2 = 420e9;     %  E2 = Ef+
nu1 = 0.3 ;     %  nu1 = nu_m    
nu2 = 0.2 ;     %  nu2 = nu_f




[N1 N2] = size(im) ;        %   number de pixel = N1*N2 
T1 = 1 ;                    %   longeur de axe x
T2 = 1 ;                    %   longeur de axe y
lambda1 = E1.*nu1./((1+nu1).*(1-2.*nu1)) ;
mu1     = 0.5.* E1./(1+nu1) ;
lambda2 = E2.*nu2./((1+nu2).*(1-2.*nu2)) ;
mu2     = 0.5.* E2./(1+nu2) ; 
lambda0 = 0.5.*(lambda1+lambda2) ;
mu0     = 0.5.*(mu1+mu2) ;
%  ---coordinates pixels reel espace --------------------------------------
[y, x] = ndgrid(linspace(0,(N1-1)*T1/N1,N1),linspace(0,(N2-1)*T2/N2,N2)) ;

% ---frequences fourier espace --------------------------------------------
[Y, X] = ndgrid(xi(N1,T1),xi(N2,T2)) ;
% Y = fft2(y);
% X = fft2(x);

C1 = C(lambda1,mu1) ;
C2 = C(lambda2,mu2) ;


% ------- deformation---------------------------------------------------
E = [1 0; 0 0] ;
for i =1:N1
    for j = 1:N2
        epsilon_i(i,j,:,:) = E ;
    end    
end

sigma_i = produ1(epsilon_i,C1,C2,im) ;

ite=0;
ee = [];
while 1
    %while erreur > 1e-4
    %Sigma_i = FFFmatlab(sigma_i);
    Sigma_i = FFF(sigma_i,X,Y,x,y) ;
    Epsilon_i = FFF(epsilon_i,X,Y,x,y);
    erreur = convergence_test(X,Y,Sigma_i) 
    if erreur < 1e-4
        break ;
    end

%   Epsilon_i1 = Epsilon_i - produ2(X,Y,Sigma_i,Epsilon_i,E,lambda0,mu0) ;
    Epsilon_i1 = Epsilon_i - produ2(X,Y,Sigma_i,Epsilon_i,E,im,lambda1,mu1,lambda2,mu2) ;
    epsilon_i1 = iFFF(Epsilon_i1,X,Y,x,y) ;
    sigma_i1 = produ1(epsilon_i1,C1,C2,im) ;
    epsilon_i = epsilon_i1 ;
    sigma_i = sigma_i1 ;


    ite=ite+1 
    ee = [ee erreur] ;
end
d_moy = [1/(N1*N2)*(sum(sum(epsilon_i(:,:,1,1))))+...
    1/(N1*N2)*(sum(sum(epsilon_i(:,:,2,2))))... 
    1/(2*N1*N2)*(sum(sum(epsilon_i(:,:,2,1))))+...
    1/(2*N1*N2)*(sum(sum(epsilon_i(:,:,1,2))))  ]
c_moy = 1/(N1*N2)*sum(sum(sigma_i(:,:,1,1))) ;

% imagesc(real(epsilon_i(:,:,1,1))) ;
% E11_N(ite_N,ite_k) = d_moy(1) ;
%     end
% end












toc ;

% plot(x1,real(E11_N(:,1)))
% [N_1 N_2 N_3 N_4] = size(sigma_i) ;
% somme_1 = 0;
% N_x = 1 ;
% N_y = 1 ;
% for m = 1 :N_1
%     for n = 1: N_2
%         somme_1 = somme_1 + sigma_i(m,n,1,1)*exp(-2*pi*(complex(0,1)*(N_x*X(m,n)/N1+N_y*Y(m,n)/N2))) ;
%     end
% end
% Sigma_i(1,1,1,1) == somme_1
%                 




















