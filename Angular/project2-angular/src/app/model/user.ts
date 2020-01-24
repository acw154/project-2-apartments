export class User {
	id: number;
	f_name:string;
	l_name:string;
	email:string;
	password: string;
	user_status: string;
	current_state: string;

	public constructor(init?: Partial<User>) {
        Object.assign(this, init);
    }
}
