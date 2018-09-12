function y = convergence_test(X,Y,Sigma_i)
% ----------------------------------------------------------------------
%
%
%
%
% -----------------------------------------------------------------------
somme = 0 ;
[N1 N2] =size(X) ;
for i = 1 : N1
    for j = 1 : N2
        somme = somme + norm([X(i,j) Y(i,j)]*[Sigma_i(i,j,1,1) Sigma_i(i,j,1,2);
            Sigma_i(i,j,2,1) Sigma_i(i,j,2,2)])^2 ;
    end
end

A = sqrt(somme) ;
%B = sqrt(Sigma_i(2,2,1,1)^2+Sigma_i(2,2,2,2)^2 +Sigma_i(2,2,2,1)^2+Sigma_i(2,2,1,2)^2);

        
y = A;

