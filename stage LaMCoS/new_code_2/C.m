function y = C(m,n,im,lambda1,mu1,lambda2,mu2)
% ------------------------------------------------------------------------
%
%
%
%
% -----------------------------------------------------------------------
[N1 N2] = size(im) ;

if im(m,n) == 0 
    for i = 1:2
        for j = 1:2
            for k = 1:2
                for h = 1:2
                    y(i,j,k,h) = lambda1.*(i==j).*(k==h) +...
                        mu1.*((i==k).*(j==h)+(i==h).*(j==k)) ;
                end
            end
        end
    end
else
    for i = 1:2
        for j = 1:2
            for k = 1:2
                for h = 1:2
                    y(i,j,k,h) = lambda2.*(i==j).*(k==h) +...
                        mu2.*((i==k).*(j==h)+(i==h).*(j==k)) ;
                end
            end
        end
    end
end

