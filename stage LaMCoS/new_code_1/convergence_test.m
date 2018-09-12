function y = convergence_test(xi_d,Sigma_i)
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
        somme = somme + norm([xi_d(i,j,1) xi_d(i,j,2)]*[Sigma_i(i,j,1,1) Sigma_i(i,j,1,2);
            Sigma_i(i,j,2,1) Sigma_i(i,j,2,2)])^2 ;
    end
end


y = sqrt(somme/(N1*N2)) / norm([sigma(1,1,1,1) sigma(1,1,2,2) sigma(1,1,1,2)]) ;





























