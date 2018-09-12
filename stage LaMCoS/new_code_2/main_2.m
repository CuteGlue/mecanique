% ---------MAIN--------------------------------------------------------
clc ;
close all ;
clear all ;

make_pixel(4,4,1,1,2,3,2,3) ;
im = imread('figure_pixel.png') ;

% ---------COEFFICIENTS-------------------------------------------------------
E1 = 70e9 ;     %  E1 = Em
E2 = 420e9;     %  E2 = Ef
nu1 = 0.3 ;     %  nu1 = nu_m    
nu2 = 0.2 ;     %  nu2 = nu_f


[N1 N2] = size(im) ;        %   pixel = N1*N2 
T1 = 1 ;        %   longeur de axe x
T2 = 1 ;        %   longeur de axe y
lambda1 = E1.*nu1./((1+nu1).*(1-2.*nu1)) 
mu1     = 0.5.* E1./(1+nu1) 
lambda2 = E2.*nu2./((1+nu2).*(1-2.*nu2)) 
mu2     = 0.5.* E2./(1+nu2)  
lambda0 = 0.5.*(lambda1+lambda2) ;
mu0     = 0.5.*(mu1+mu2) ;

%  ---coordinates pixels reel espace --------------------------------------
[y, x] = ndgrid(linspace(0,(N1-1)*T1/N1,N1),linspace(0,(N2-1)*T2/N2,N2)) ;
[Y, X] = ndgrid(xi(N1,T1),xi(N2,T2)) ;


% ---frequences fourier espace --------------------------------------------
% for i = 1 :N1
%     for j = 1 :N2 
%         X(i,j), Y(i,j) = fft([i*T1/N1 j*T2/N2]) ;
%     end
% end
%[Y, X] = ndgrid(fft(linspace(0,(N1-1)*T1/N1,N1)),fft(linspace(0,(N2-1)*T2/N2,N2))) ;
% a = fft2(im) ;
% ------- deformation---------------------------------------------------
e(:,:,1) = [1 0;0 0] ;
e(:,:,2) = [0 0;0 1] ;
e(:,:,3) = [0 1;1 0] ;
def = [] ;
C_moy = [] ; 
ERREUR = [] ; 
for col = 1:3    
    E = e(:,:,1) ;
% ----- ITERATION -------------------------------------------------------------------------

    ee = [];

    for i =1:N1
        for j = 1:N2
            epsilon_i(i,j,:,:) = E ;
        end    
    end

    sigma_i = produ_c_epsi(x,y,epsilon_i,im,lambda1,mu1,lambda2,mu2) ;
    erreur =10 ;
    ite=0;
    %
    while erreur > 1e-4
        %while erreur > 1e-4

        Sigma_i = FFF(sigma_i) ;
        Epsilon_i = FFF(epsilon_i) ;
        erreur = convergence_test(X,Y,Sigma_i) 
        if erreur < 1e-4
            break ;
        end

        Epsilon_i1 = Epsilon_i - produ_gamma_sigma(X,Y,Sigma_i,lambda0,mu0,Epsilon_i,E,im,lambda1,mu1,lambda2,mu2) ;
        epsilon_i1 = iFFF(Epsilon_i1) ;
        sigma_i1 = produ_c_epsi(x,y,epsilon_i1,im,lambda1,mu1,lambda2,mu2) ;


        epsilon_i = epsilon_i1 ;
        sigma_i = sigma_i1 ;
        ite=ite+1 
        ee = [ee erreur] ;
    end
    def_moy = [1/(N1*N2)*sum(sum(epsilon_i(:,:,1,1))) ; 1/(N1*N2)*sum(sum(epsilon_i(:,:,2,2)));...
             1/(2*N1*N2)*sum(sum(epsilon_i(:,:,1,2)))+1/(2*N1*N2)*sum(sum(epsilon_i(:,:,2,1)))]; 

    temp = [1/(N1*N2)*sum(sum(sigma_i(:,:,1,1))) ; 1/(N1*N2)*sum(sum(sigma_i(:,:,2,2)));...
             1/(2*N1*N2)*sum(sum(sigma_i(:,:,1,2)))+1/(2*N1*N2)*sum(sum(sigma_i(:,:,2,1)))];


    def = [def def_moy(col)] ;
    C_moy = [C_moy temp] ;

end


def
size(C_moy)
C_moy
plot(ee) ;
% plot(ee(:,2)) ;
% plot(ee(:,3)) ;


































