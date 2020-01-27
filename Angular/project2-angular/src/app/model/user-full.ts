import { Preference } from './preference';
import { Property } from './property';
import { Status } from './status';

export class UserFull {
    id: number;
	f_name:string;
	l_name:string;
	email:string;
	password: string;
	user_status: string;
    current_state: string;
    preference: Preference;
    savedProperties: Property[];
    status: string;

	public constructor(init?: Partial<UserFull>) {
        Object.assign(this, init);
    }
}
