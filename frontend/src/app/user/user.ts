export class User {
  constructor(number: number, s: string, number2: number) {
    this.id = number;
    this.name = s;
    this.imageId = number2;
  }

  id: number;
  name: string;
  imageId: number;
}
