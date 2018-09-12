function y = erreur_converge(xi_d,sigma)
% -------------------------------------------------------------------------
%
%
%
%
% -------------------------------------------------------------------------
somme = 0 ;
[N1, N2] = size(xi_d(:,:,1)) ;
for i = 1 : N1
    for j = 1 : N2
        somme = somme + norm([xi_d(i,j,1)* xi_d(i,j,2)])^2 ;
    end
end


y = sqrt(somme/(N1*N2)) / (sigma(0)) ;





























