function y = convergence_test(X,Y,Sigma_i)
% ----------------------------------------------------------------------
%
%
%
%
% -----------------------------------------------------------------------
somme = 0 ;
moy11 = 0;
moy12 = 0;
moy21 = 0;
moy22 = 0;
[N1 N2] =size(X) ;
for i = 1 : N1
    for j = 1 : N2
        somme = somme + norm([X(i,j) Y(i,j)]*[Sigma_i(i,j,1,1) Sigma_i(i,j,1,2);
            Sigma_i(i,j,2,1) Sigma_i(i,j,2,2)])^2 ;
        moy11 = moy11 + Sigma_i(i,j,1,1);
        moy12 = moy12 + Sigma_i(i,j,1,2);
        moy21 = moy21 + Sigma_i(i,j,2,1);
        moy22 = moy22 + Sigma_i(i,j,2,2);
    end
end

moy11 = norm(moy11/(N1*N2)); 
moy12 = norm(moy12/(N1*N2)); 
moy21 = norm(moy21/(N1*N2));
moy22 = norm(moy22/(N1*N2)); 

A = sqrt(somme/(N1*N2)) ;
B = sqrt(moy11^2+moy12^2+moy21^2+moy22^2) ;

        
y = A/B;

