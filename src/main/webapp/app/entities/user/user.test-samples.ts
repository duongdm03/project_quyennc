import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 14374,
  login: 'koQc',
};

export const sampleWithPartialData: IUser = {
  id: 14427,
  login: '$2CE43@x4MyN\\ubTC\\yz-\\ GB',
};

export const sampleWithFullData: IUser = {
  id: 24446,
  login: '8@k\\r87j-\\eIae\\0e7',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
