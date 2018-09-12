tic ;
clc; 
clear all;
close all;


im = imread('mat_composit.png') ;

im1 = rgb2gray(im) ;
figure(1)
imshow(im1) ;

im2 = fft2(im1) ;
figure(2)
imshow(im2) ;

% im3 = fftshift(im2) ;
% figure(3)
% imshow(im3) ;
% 
% im4 = fftshift(im3) ;
% figure(4)
% imshow(im4);




im5 = ifft2(im2) ;
figure(5)
imshow(im5, [])




toc ;
