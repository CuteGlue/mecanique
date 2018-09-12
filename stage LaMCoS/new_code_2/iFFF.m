function y = iFFF(A)
% ---------------------------------------------------------------------
%
%
%
%
%
% ----------------------------------------------------------------------
[a b c d] = size(A) ;
for i = 1 : a
    for j = 1 : b
        h1(i,j) = A(i,j,1,1) ;
        h2(i,j) = A(i,j,1,2) ; 
        h3(i,j) = A(i,j,2,1) ;
        h4(i,j) = A(i,j,2,2) ;
    end
end

H1 = ifft(h1) ;
H2 = ifft(h2) ;
H3 = ifft(h3) ;
H4 = ifft(h4) ;

for i = 1:a
    for j = 1:b
        y(i,j,1,1) = H1(i,j) ;
        y(i,j,1,2) = H2(i,j) ;
        y(i,j,2,1) = H3(i,j) ;
        y(i,j,2,2) = H4(i,j) ;
    end
end