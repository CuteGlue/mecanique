function y = convergence_test(X,Y,Sigma_i)
% ----------------------------------------------------------------------
%
%
%
%
% -----------------------------------------------------------------------
somme = 0 ;
[N1 N2] =size(X) ;
a = 1;
b = 1;
for i = 1 : N1
    for j = 1 : N2
        somme = somme + norm([X(i,j) Y(i,j)]*[Sigma_i(i,j,1,1) Sigma_i(i,j,1,2);
            Sigma_i(i,j,2,1) Sigma_i(i,j,2,2)])^2 ;
        if X(i,j)==0 && Y(i,j)==0
            a = i;
            b = j;
        end
    end
end

ii=intersect(find(X==0),find(Y==0));

y = sqrt(somme/(N1*N2)) ;

