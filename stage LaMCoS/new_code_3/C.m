function [y] = C(lambda,mu)
% --------------------------------------------
%
%
%
%
% --------------------------------------------
for i = 1:2
    for j = 1:2
        for k = 1:2
            for h = 1:2
                y(i,j,k,h) = lambda*(i==j)*(k==h) + mu*((i==k)*(j==h)+(i==h)*(j==k));
            end
        end
    end
end


    


