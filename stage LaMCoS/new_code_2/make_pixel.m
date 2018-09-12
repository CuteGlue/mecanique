function make_pixel(N1,N2,T1,T2,a1,a2,b1,b2)
close all ;
% --------------------------------------------------------------------
%   input : 
%       rien
%   output
%       1. coornonnees dans l'espace réel
%       2. 9 pixels
%       3. figure de coordonnes et figure de pixel
% --------------------------------------------------------------------


for i = 1:N1
    for j = 1:N2
        p(i,j) = 0;
    end
end
for i = a1 : a2
    for j = b1:b2
        p(i,j) = 1 ;
    end
end
pixel = p ;
imwrite(pixel,'figure_pixel.png') ;