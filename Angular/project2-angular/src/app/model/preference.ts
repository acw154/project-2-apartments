export class Preference {
    email: string;
    minPrice: number;
    maxPrice: number;
    numBeds: number;
    numBaths: number;
    city: string;
    state_code: string;

    public constructor(init?: Partial<Preference>) {
        Object.assign(this, init);
    }
}
