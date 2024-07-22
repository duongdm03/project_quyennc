import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: 'a59d49b9-1475-4d1f-8e18-3c279505277a',
};

export const sampleWithPartialData: IAuthority = {
  name: 'd4fdf365-bc90-40dd-9943-afca2a6027d7',
};

export const sampleWithFullData: IAuthority = {
  name: '492829b8-89d1-43a3-90f1-29f43f60b447',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
