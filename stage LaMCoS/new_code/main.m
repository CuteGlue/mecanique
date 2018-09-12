% ----- DEBUT -------------------------------------------------------------
close all ;
clear all;
clc ;
% ----- COEFFECIENTS : ---------------------------------------------------
E1 = 70 ;
E2 = 420 ;
nu1 = 0.25 ;
nu2 = 0.25 ;
lambda1  = E1.*nu1./((1+nu1).*(1-2.*nu1)) ;
mu1  =0.5.* E1./(1+nu1) ;
lambda2  = E2.*nu2./((1+nu2).*(1-2.*nu2)) ;
mu2  =0.5.* E2./(1+nu2) ;
lambda0 = 0.5.*(lambda1+lambda2) ;
mu0 = 0.5.*(mu1+mu2) ;
C = C_elas(lambda0,mu0) ;
% ------- INITIAL ------------------------------------------------------
[x, y, pixel] = make_pixel ;
Fx = fft(x) ;
Fy = fft(y) ;
epsilon_0 = [0.05 0 0]' ;
sigma_0 = C*epsilon_0 ;
sigma_m = 0.5*(sigma_0(1)+sigma_0(2)) ;

% -------ITERATION pour premier pixel ------------------------------------------------------
ite = 1 ;
somme = 0 ;
while 1
    Fsigma_0 = fft(sigma_0) ;
    Fepsilon_0 = fft(epsilon_0) ;
    for i =1 :3
        for j =1 : 3
            somme = somme + norm([norm(Fx(1,1) Fy(1,1) 0]*Fsigma_0).^2 ;  
           end
    end
    error_tmp = sqrt(somme)./norm(Fsigma_0) ;
    erreur(ite) = error_tmp ;     
    if error_tmp < 10e-4
        break ;
    end
    gamma_0 = 
    Fgamma_0 = fft(gamma_0) ;
    Fepsilon_1 = F_epsilon_0 - Fgamma_0*Fsigma_0 ;
    epsilon_1 = ifft(Fepsilon_1) ;
    sigma_1 = C*epsilon_1 ;
    sigma_0 = sigma_1 ;
    epsilon_0 = emsolon_1 ;
    
end
figure(1) 
plot((i:ite),erreur(:),'*') ;
figure(2)
plot((1:ite),Sigma_m/sigma_m,'*') ;













% --------- END ---------------------------------------------------------

