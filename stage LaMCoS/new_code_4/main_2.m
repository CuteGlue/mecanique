% ---------MAIN--------------------------------------------------------
clc ;
close all ;
clear all ;

make_pixel(4,4,0.1) ;
im = imread('figure_pixel.png') ;

% ---------COEFFICIENTS-------------------------------------------------------
E1 = 70e9 ;     %  E1 = Em
E2 = 420e9;     %  E2 = Ef
nu1 = 0.3 ;     %  nu1 = nu_m    
nu2 = 0.2 ;     %  nu2 = nu_f
E2 =E1 ;
nu2 = nu1 ;



[N1 N2] = size(im) ;        %   number de pixel = N1*N2 
T1 = 1 ;                    %   longeur de axe x
T2 = 1 ;                    %   longeur de axe y
lambda1 = E1.*nu1./((1+nu1).*(1-2.*nu1)) ;
mu1     = 0.5.* E1./(1+nu1) ;
lambda2 = E2.*nu2./((1+nu2).*(1-2.*nu2)) ;
mu2     = 0.5.* E2./(1+nu2) ; 

%  ---coordinates pixels reel espace --------------------------------------
[y, x] = ndgrid(linspace(0,(N1-1)*T1/N1,N1),linspace(0,(N2-1)*T2/N2,N2)) ;

% ---frequences fourier espace --------------------------------------------
[Y, X] = ndgrid(xi(N1,T1),xi(N2,T2)) ;

C0 = C(im,lambda1,mu1,lambda2,mu2) ;
[Gamma_0,x_0,y_0] = Gamma(im,X,Y,lambda1,mu1,lambda2,mu2) ;

% ------- deformation---------------------------------------------------
E = [1 0; 0 0] ;
for i =1:N1
    for j = 1:N2
        epsilon_i(i,j,:,:) = E ;
    end    
end

sigma_i = produ1(epsilon_i,C0) ;

ite=0;
ee = [];
while 1
    %while erreur > 1e-4

    Sigma_i = FFF(sigma_i) ;
    Epsilon_i = FFF(epsilon_i)   ;
    erreur = convergence_test(X,Y,Sigma_i) 
    if erreur < 1e-4
        break ;
    end

    Epsilon_i1 = Epsilon_i - produ2(Gamma_0,Sigma_i,Epsilon_i,x_0,y_0,E) ;
    epsilon_i1 = iFFF(Epsilon_i1) ;
    sigma_i1 = produ1(epsilon_i1,C0) ;
    epsilon_i = epsilon_i1 ;
    sigma_i = sigma_i1 ;


    ite=ite+1 
    ee = [ee erreur] ;
end
d_moy = [1/(N1*N2)*(sum(sum(epsilon_i(:,:,1,1)))) 1/(N1*N2)*(sum(sum(epsilon_i(:,:,2,2))))... 
    1/(2*N1*N2)*(sum(sum(epsilon_i(:,:,2,1))))+1/(2*N1*N2)*(sum(sum(epsilon_i(:,:,1,2))))  ]
c_moy = 1/(N1*N2)*sum(sum(sigma_i(:,:,1,1)))

imagesc(real(epsilon_i(:,:,1,1)))
































