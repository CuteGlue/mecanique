function y = C(im,lambda1,mu1,lambda2,mu2)
% ------------------------------------------------------------------------
%
%
%
%
% -----------------------------------------------------------------------
[N1 N2] = size(im) ;
for m = 1 :N1
    for n = 1: N2
        for i = 1:2
            for j = 1:2
                for k = 1:2
                    for h = 1:2
                        if im(m,n) == 0
                            y(m,n,i,j,k,h) = lambda1*(i==j)*(k==h) + mu1*((i==k)*(j==h)+(i==h)*(j==k));
                        else
                            y(m,n,i,j,k,h) = lambda2*(i==j)*(k==h) + mu2*((i==k)*(j==h)+(i==h)*(j==k));
                        end
                    end
                end
            end
        end
    end
end
    


