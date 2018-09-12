function y = prodcution1(x_d,epsilon_i,lambda0,mu0)
% -----------------------------------------------------------------------
%
%
%
%
%
%
% -----------------------------------------------------------------------
[N1 N2] = size(x_d(:,:,1)) ;
C_0= C(lambda0,mu0) ;
for m=1:N1
    for n=1:N2
        for i =1:2
            for j= 1:2
                 y(m,n,i,j) = sum(sum([C_0(i,j,1,1) C_0(i,j,1,2); C_0(i,j,2,1) C_0(i,j,2,2)]*...
                     [epsilon_i(i,j,1,1) epsilon_i(i,j,1,2); epsilon_i(i,j,2,1) epsilon_i(i,j,2,2)]));
            end
        end
    end
end


                     
       
        


















